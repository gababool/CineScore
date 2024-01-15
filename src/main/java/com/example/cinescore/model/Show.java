package com.example.cinescore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Show implements Serializable, Media {

    private String title;
    private int releaseYear;
    private String showId;
    ArrayList<Integer> ratings;
    ArrayList<String> reviews;

    public Show(String title, int releaseYear){
        this.title = title;
        this.releaseYear = releaseYear;
        this.showId = generateShowId(this.title, this.releaseYear);
    }
    public Show(){};

    public String getTitle() {
        return title;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public String getFullTitle(){
        return title + " (" + releaseYear + ")";
    }

    public double getAvgRating(){
        int scoreTotal = 0;
        for(int score : ratings){
            scoreTotal += score;
        }
        return (double) scoreTotal /(ratings.size());
    }

    public String getUserRating(){
        User user = UserManager.getInstance().getCurrentUser();
        return user.getMovieRating(this.showId);
    }

    public static String generateShowId(String title, int releaseYear){
        StringBuilder output = new StringBuilder();
        char[] titleArray = title.toCharArray();
        for(char letter : titleArray){
            String letterAsString = String.valueOf(letter);
            if(letterAsString.matches("[a-zA-Z]+")){
                output.append(letterAsString.toLowerCase());
            }
        }
        output.append(releaseYear);
        return output.toString();
    }

    public void addRatingScore(int score){
        ratings.add(score);
    }
}


