package com.example.cinescore.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class User implements Serializable {

    private String username;
    private String password;
    private String email;
    private HashMap<String, Integer> ratedMovies;

    public User(String username, String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.ratedMovies = new LinkedHashMap<>();
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


}
