package com.example.cinescore.model;

import java.io.Serializable;
import java.util.ArrayList;
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
    private ArrayList<Integer> ratings;
    private ArrayList<String> reviews;

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
        this.ratings = new ArrayList<>();
        this.reviews = new ArrayList<>();

    }

    public Movie(){};

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

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    public String getMovieId() {
        return movieId;
    }

    // Need truncation to two decimals
    public double getAvgRating(){
        int scoreTotal = 0;
        for(int score : ratings){
            scoreTotal += score;
        }
        return (double) scoreTotal /(ratings.size());
    }

    public String getUserRating(){
        User user = UserManager.getInstance().getCurrentUser();
        return user.getMovieRating(this.movieId);
    }

    public void addRatingScore(int score){
        User user = UserManager.getInstance().getCurrentUser();
        if (user.getRatedMovies().containsKey(this.movieId)){
            int previousRating = Integer.parseInt(user.getMovieRating(this.movieId));
            updateRatingScore(previousRating, score);
        } else {
            ratings.add(score);
        }
    }

    private void updateRatingScore(int previousScore, int newScore){
        for (int i = 0; i < ratings.size(); i++){
            if (ratings.get(i) == previousScore){
                ratings.remove(ratings.get(i));
                ratings.add(newScore);
                break;
            }
        }
    }

}
