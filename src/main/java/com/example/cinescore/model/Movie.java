package com.example.cinescore.model;

import java.io.Serializable;
import java.util.UUID;


public class Movie implements Serializable {

    UUID movieId;
    String title;
    String director;
    int releaseYear;
    int length;

    public Movie(String title, String director, int releaseYear, int length){
        this.movieId = UUID.randomUUID();
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.length = length;
    }
}
