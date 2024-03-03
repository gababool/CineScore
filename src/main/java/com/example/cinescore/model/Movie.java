package com.example.cinescore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;


public class Movie implements Serializable {
    private String movieId;
    private String title;
    private String director;
    private String releaseYear;
    private String writer;
    private String runtime;
    private String actors;
    private String plot;
    private String poster;

    public Movie(String title, String director, String releaseYear, String writer, String runtime, String actors, String plot, String id, String poster){
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.writer = writer;
        this.runtime = runtime;
        this.actors = actors;
        this.plot = plot;
        this.movieId = id;
        this.poster = poster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return releaseYear == movie.releaseYear && Objects.equals(title, movie.title) && Objects.equals(director, movie.director);
    }
    @Override
    public int hashCode() {
        return Objects.hash(title, director, releaseYear);
    }

    public String getFullTitle(){
        return title + " (" + releaseYear + ")";
    }

    public String getWriter() {
        return writer;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public String getPoster() {
        return poster;
    }

    public String getDirector(){
        return director;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getUserRating(String username){
        // Use DAO method
        return "";
    }

    public String getUserReview(String username){
        // Use DAO method
        return "";
    }

    public ArrayList<String> getAllReviews(){
        return new ArrayList<>();
    }

    public double getAvgRating(){
        // Use DAO method
        return 1;
    }

    public int getTotalRatings(){
        // Use DAO method
        return 1;
    }

    public void addNewRating(int score) {
        // Use DAO method
    }

    public void addToWatchlist(){
        // Use DAO method
    }

    public void addReview(String text){
        // Use DAO method
    }

}
