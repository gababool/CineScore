package com.example.cinescore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;


public class Movie implements Serializable {

    UUID movieId;
    String title;
    String director;
    int releaseYear;
    int length;
    ArrayList<Integer> ratings;
    ArrayList<String> reviews;

    public Movie(String title, String director, int releaseYear, int length){
        this.movieId = UUID.randomUUID();
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.length = length;
        this.ratings = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }
}
