package com.example.cinescore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;


public class Movie implements Serializable {

    String movieId;
    String title;
    String director;
    int releaseYear;
    ArrayList<Integer> ratings;
    ArrayList<String> reviews;

    public Movie(String title, String director, int releaseYear){
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.ratings = new ArrayList<>();
        this.reviews = new ArrayList<>();
        this.movieId = generateMovieId(this.title, this.director, this.releaseYear);
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

    public String getDirector(){
        return director;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
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
        double avgRating = (double) scoreTotal /(ratings.size());
        return avgRating;
    }

    public String getUserRating(){
        User user = UserManager.getInstance().getCurrentUser();
        return user.getMovieRating(this.movieId);
    }

    // Fix code duplication here!
    public static String generateMovieId(String title, String director, int releaseYear){
        StringBuilder output = new StringBuilder();
        char[] titleArray = title.toCharArray();
        for(char letter : titleArray){
            String letterAsString = String.valueOf(letter);
            if(letterAsString.matches("[a-zA-Z]+")){
                output.append(letterAsString.toLowerCase());
            }
        }
        char[] directorArray = director.toCharArray();
        for(char letter : directorArray){
            String letterAsString = String.valueOf(letter);
            if(letterAsString.matches("[a-zA-Z]+")){
                output.append(letterAsString.toLowerCase());
            }
        }
        output.append(releaseYear);
        return output.toString();
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
