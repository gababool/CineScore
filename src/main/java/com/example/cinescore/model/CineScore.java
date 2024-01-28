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

    public void createUser(String username, String email, String password) throws Exception {
        if(users.containsKey(username)){throw new Exception("Username is taken");}
        User newUser = new User(username, email, password);
        users.put(username, newUser);
        DataManager.saveState(this);
    }

    public User loginUser(String username, String password) throws Exception {
        if(users.containsKey(username)){
            User user = users.get(username);
            if(user.getPassword().equals(password)){
                System.out.println("Login success! Welcome " + username + "!");
                return user;
            } else {
                throw new Exception("Password incorrect. Try again!");
            }
        } else {
            throw new Exception("User does not exist");
        }
    }

    public void addMovieRating(String title, String director, int releaseYear, int rating){
        User user = UserManager.getInstance().getCurrentUser();
        String movieId = Movie.generateMovieId(title, director, releaseYear);
        Movie movie = movies.get(movieId);
        if (movie == null){
            movies.put(movieId, new Movie(title, director, releaseYear));
            movie = movies.get(movieId);
        }
        movie.addRatingScore(rating);
        user.addRatedMovie(movieId, rating);
        DataManager.saveState(this);
    }

    public void addMovieToWatchlist(Movie movie){
        User user = UserManager.getInstance().getCurrentUser();
        user.addMovieToWatchlist(movie);
        DataManager.saveState(this);
    }

    public Movie getMovie(String id){
        return movies.get(id);
    }





}
