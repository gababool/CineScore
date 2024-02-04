package com.example.cinescore.model;

import com.example.cinescore.CineScoreApp;

import java.io.Serializable;
import java.util.*;

public class User implements Serializable {
    private String username;
    private String password;
    private HashMap<String, Integer> ratedMovies;
    private HashMap<String, String> reviews;
    private HashMap<String, Movie> watchlist;

    public User(String username, String password) throws Exception {
        this.username = checkUsername(username);
        this.password = checkPassword(password);
        this.ratedMovies = new LinkedHashMap<>();
        this.reviews = new HashMap<>();
        this.watchlist = new LinkedHashMap<>();
    }

    public User(){}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void addRatedMovie(String movieId, int rating){
        ratedMovies.put(movieId, rating);
    }

    public String getMovieRating(String movieId){
        if (ratedMovies.containsKey(movieId)){
            return String.valueOf(ratedMovies.get(movieId));
        } else{
            return "Not rated";
        }
    }

    public void addMovieToWatchlist(Movie movie){
        if (!watchlist.containsKey(movie.getMovieId())){
            watchlist.put(movie.getMovieId(), movie);
        }
    }

    public HashMap<String, Integer> getRatedMovies() {
        return ratedMovies;
    }

    public HashMap<String, Movie> getWatchlist() {
        return watchlist;
    }

    // Cannot call this method "getRatedMoviesAsList" because of how data storage works.
    public ArrayList<Movie> retrieveRatedMoviesAsList() {
        ArrayList<Movie> movies = new ArrayList<>();
        for (String movieId: this.ratedMovies.keySet()){
            Movie movie = CineScoreApp.getCineScore().getMovie(movieId);
            movies.add(movie);
        }
        return movies;
    }

    public ArrayList<Movie> retrieveWatchlistAsList() {
        ArrayList<Movie> movies = new ArrayList<>();
        for (String movieId: this.watchlist.keySet()){
            Movie movie = CineScoreApp.getCineScore().getMovie(movieId);
            movies.add(movie);
        }
        return movies;
    }

    public String checkUsername(String username) throws Exception{
        if(username.isBlank()){
            throw new Exception("Username cannot be blank");
        }
        if(!username.matches("[a-zA-Z0-9]+")){
            throw new Exception("Invalid username. Must only contain letters and/or digits.");
        }
        if(username.length() > 12){
            throw new Exception("Username length cannot exceed 12 characters");
        }
        return username;
    }

    public String checkPassword(String password) throws Exception{
        if(password.isBlank()){
            throw new Exception("Password cannot be blank");
        }
        if(password.length() > 16){
            throw new Exception("Username length cannot exceed 16 characters");
        }
        return password;
    }

    public void setUsername(String username) throws Exception {
        this.username = checkUsername(username);
    }

    public void setPassword(String password) throws Exception {
        this.password = checkPassword(password);
    }

    public void addReview(Movie movie, String text){
        reviews.put(movie.getMovieId(), text);
    }
}
