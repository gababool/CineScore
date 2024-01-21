package com.example.cinescore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class User implements Serializable {
    private String username;
    private String password;
    private String email;
    private HashMap<String, Integer> ratedMovies;
    private HashMap<String, String> reviews;
    private ArrayList<Movie> watchlist;

    public User(String username, String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.ratedMovies = new LinkedHashMap<>();
        this.reviews = new  LinkedHashMap<>();
        this.watchlist = new ArrayList<>();
    }

    public User(){}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
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
        watchlist.add(movie);
    }

    public HashMap<String, Integer> getRatedMovies() {
        return ratedMovies;
    }
}
