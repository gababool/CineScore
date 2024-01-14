package com.example.cinescore.model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    String username;
    String password;
    ArrayList<Movie> ratedMovies;
    ArrayList<Show> ratedShows;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.ratedMovies = new ArrayList<>();
        this.ratedShows = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Movie> getRatedMovies() {
        return ratedMovies;
    }

    public ArrayList<Show> getRatedShows() {
        return ratedShows;
    }
}
