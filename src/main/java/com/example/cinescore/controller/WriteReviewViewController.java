package com.example.cinescore.controller;

import com.example.cinescore.CineScoreApp;
import com.example.cinescore.model.CineScore;
import com.example.cinescore.model.Movie;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class WriteReviewViewController {

    public TextArea reviewText;
    public ImageView moviePoster;
    public Button addReviewButton;
    public Button cancelButton;
    Movie currentMovie = null;

    public void loadMovieInfo(Movie movie) {
        currentMovie = movie;
        try {
            InputStream stream = new URL(movie.getPoster()).openStream();
            Image image = new Image(stream);
            moviePoster.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addReview(ActionEvent event) {
        CineScore cineScore = CineScoreApp.getCineScore();
        try {
            cineScore.addMovieReview(currentMovie, reviewText.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            SceneSwitcher.switchToMoviePage(event, currentMovie);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cancelReview(ActionEvent event) {
        try {
            SceneSwitcher.switchToMoviePage(event, currentMovie);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
