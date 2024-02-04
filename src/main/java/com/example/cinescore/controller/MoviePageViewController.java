package com.example.cinescore.controller;

import com.example.cinescore.CineScoreApp;
import com.example.cinescore.model.CineScore;
import com.example.cinescore.model.Movie;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MoviePageViewController {


    public ImageView posterImageView;
    public Label movieTitleLabel;
    public Label movieDirectorLabel;
    public Label movieReleaseYearLabel;
    public Label movieWriterLabel;
    public Label moviePlotLabel;
    public ListView<String> reviewsListView;
    public Button returnButton;
    public Button addToWatchlistButton;
    public Button rateMovieButton;
    public Button reviewMovieButton;
    public Movie currentMovie = null;

    public void loadMovieInfo(Movie movie){
        currentMovie = movie;
        movieTitleLabel.setText(movie.getTitle());
        movieDirectorLabel.setText(movie.getDirector());
        movieReleaseYearLabel.setText(movie.getReleaseYear());
        moviePlotLabel.setText(movie.getPlot());
        try{
            InputStream stream = new URL(movie.getPoster()).openStream();
            Image image = new Image(stream);
            posterImageView.setImage(image);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void returnToMain(ActionEvent event) {
        try {
            SceneSwitcher.switchToMain(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addToAWatchlist(ActionEvent event) {
        CineScore cineScore = CineScoreApp.getCineScore();
        if (currentMovie != null) {
            cineScore.addMovieToWatchlist(currentMovie);
        }
    }

    public void rateMovie(ActionEvent event) {
        if (currentMovie != null) {
            try {
                SceneSwitcher.switchToRateMovieView(event, currentMovie);
                currentMovie = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addReview(ActionEvent event) {
        // Go to write review page
    }
}
