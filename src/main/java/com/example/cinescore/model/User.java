package com.example.cinescore.model;

import com.example.cinescore.CineScoreApp;

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

    public User(String username, String email, String password) throws Exception {
        this.username = checkUsername(username);
        this.password = checkPassword(password);
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
    public ArrayList<Movie> getRatedMoviesAsList() {
        ArrayList<Movie> movies = new ArrayList<>();
        for (String movieId: this.ratedMovies.keySet()){
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
        if(username.length() > 16){
            throw new Exception("Username length cannot exceed 16 characters");
        }
        return password;
    }

}
