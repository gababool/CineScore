package com.example.cinescore.model;

import java.io.Serializable;
import java.util.HashMap;

public class CineScore implements Serializable {
    private HashMap<String, User> users;
    private HashMap<String, Movie> movies;
    private String name;

    public CineScore(String name){
        this.users = new HashMap<>();
        this.movies = new HashMap<>();
        this.name = name;
    }
    public CineScore(){};

    public HashMap<String, Movie> getMovies() {
        return movies;
    }

    public void createUser(String username, String password) throws Exception {
        if(users.containsKey(username)){throw new Exception("Username is taken");}
        User newUser = new User(username, password);
        users.put(username, newUser);
        DataManager.saveState(this);
    }

    public User loginUser(String username, String password) throws Exception {
        if (username.isBlank()){throw new Exception("Username cannot be blank");}
        if (password.isBlank()){throw new Exception("Password cannot be blank");}
        if(users.containsKey(username)){
            User user = users.get(username);
            if(user.getPassword().equals(password)){
                System.out.println("Login success! Welcome " + username + "!");
                return user;
            } else {throw new Exception("Password incorrect. Try again!");}
        } else {throw new Exception("User does not exist");}
    }

    public void changeUsername(String username) throws Exception{
        User user = UserManager.getInstance().getCurrentUser();
        String oldUsername = user.getUsername();
        user.setUsername(username);
        users.put(user.getUsername(), user);
        users.remove(oldUsername);
        DataManager.saveState(this);
    }

    public void changePassword(String password) throws Exception{
        User user = UserManager.getInstance().getCurrentUser();
        user.setPassword(password);
        DataManager.saveState(this);
    }

    public void addMovieRating(Movie movie, int rating) throws Exception {
        User user = UserManager.getInstance().getCurrentUser();
        if (movie==null){
            throw new Exception("Movie not found");
        }
        if (!movies.containsKey(movie.getMovieId())){
            movies.put(movie.getMovieId(), movie);
        }
        movie = movies.get(movie.getMovieId()); // Changed reference to movie, otherwise avg calc will not work
        movie.addRatingScore(rating);
        user.addRatedMovie(movie.getMovieId(), rating);
        DataManager.saveState(this);
    }

    public void addMovieToWatchlist(Movie movie){
        User user = UserManager.getInstance().getCurrentUser();
        if (!movies.containsKey(movie.getMovieId())){
            movies.put(movie.getMovieId(), movie);
        }
        movie = movies.get(movie.getMovieId()); // Changed reference to movie, otherwise avg calc will not work
        user.addMovieToWatchlist(movie);
        DataManager.saveState(this);
    }

    public Movie getMovie(String id){
        return movies.get(id);
    }

    public void addMovieReview(Movie movie, String text) throws Exception {
        User user = UserManager.getInstance().getCurrentUser();
        Movie toBeReviewed = movies.get(movie.getMovieId());
        String ratingScore = user.getMovieRating(movie.getMovieId());
        if (ratingScore.equals("Not rated"))
            throw new Exception("Movie must be rated before a review can be added");
        if (text.isBlank()){
            throw new Exception("Review text cannot be blank");
        }
        toBeReviewed.addReview(user, ratingScore, text);
        user.addReview(toBeReviewed, text);
        DataManager.saveState(this);
    }



}
