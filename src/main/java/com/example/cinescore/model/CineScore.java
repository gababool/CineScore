package com.example.cinescore.model;

import java.io.Serializable;
import java.util.HashMap;

public class CineScore implements Serializable {
    HashMap<String, User> users;
    HashMap<String, Movie> movies;
    HashMap<String, Show> shows;

    public CineScore(){
        this.users = new HashMap<>();
        this.movies = new HashMap<>();
        this.shows = new HashMap<>();

    }
}
