package com.example.cinescore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;


public class Movie implements Serializable {

    private int totalRatings;
    private int totalScore;
    private String movieId;
    private String title;
    private String director;
    private String releaseYear;
    private String writer;
    private String runtime;
    private String actors;
    private String plot;
    private String poster;
    private HashMap<String, String> reviews;

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
        this.totalRatings = 0;
        this.totalScore = 0;
        this.reviews = new HashMap<>();
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

    public HashMap<String, String> getReviews() {
        return reviews;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getAvgRating(){
        double avgRating = (double) totalScore / totalRatings;
        return String.valueOf(avgRating) + " (" + totalRatings + ")";
    }

    public String getUserRating(){
        if (UserManager.getInstance().getCurrentUser() != null){
            User user = UserManager.getInstance().getCurrentUser();
            return user.getMovieRating(this.movieId);
        } else {
            System.out.println("User is null");
            return "User is currently null";
        }
    }

    public void addRatingScore(int score) {
        User user = UserManager.getInstance().getCurrentUser();
        if (user.getRatedMovies().containsKey(this.movieId)) {
            System.out.println("Inside condition");
            int previousScore = Integer.parseInt(user.getMovieRating(this.movieId));
            System.out.println("Previous score: " + previousScore);
            if (totalScore - previousScore <= 0) {
                totalScore = 0;
            } else {
                totalScore -= previousScore;
            }
            totalScore += score;
        } else {
            totalScore += score;
            totalRatings++; // Increment totalRatings only when a new rating is added
        }
    }

    public void addReview(User user, String ratingScore, String text){
        String lineSeparator = System.lineSeparator();
        String review = "User "+ user.getUsername()+": " + ratingScore+"/10" + lineSeparator + text;
        reviews.put(user.getUsername(), review);
    }

}
