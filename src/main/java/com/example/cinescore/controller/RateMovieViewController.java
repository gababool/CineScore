package com.example.cinescore.controller;

import com.example.cinescore.CineScoreApp;
import com.example.cinescore.model.CineScore;
import com.example.cinescore.model.Movie;
import com.example.cinescore.model.MovieAPIService;
import com.example.cinescore.model.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class RateMovieViewController {

    public Label titleLabel;
    public Slider slider;
    public Label ratingFromSlider;
    public Button addRatingButton;
    public Button returnButton;
    public ImageView moviePoster;
    public Label movieTitleLabel;
    public Label movieDirectorLabel;
    public Label movieReleaseYearLabel;
    public Label movieWriterLabel;
    public Label moviePlotLabel;
    public static Movie currentMovie = null;

    public void loadMovieInfo(Movie movie){
        currentMovie = movie;
        movieTitleLabel.setText(movie.getTitle());
        movieDirectorLabel.setText(movie.getDirector());
        movieReleaseYearLabel.setText(movie.getReleaseYear());
        moviePlotLabel.setText(movie.getPlot());
        try{
            InputStream stream = new URL(movie.getPoster()).openStream();
            Image image = new Image(stream);
            moviePoster.setImage(image);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void rateMovie(ActionEvent event){
        int rating = (int)slider.getValue();
        CineScore cineScore = CineScoreApp.getCineScore();
        try {
            currentMovie.addNewRating(rating);
            currentMovie = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRatingLabel(MouseEvent mouseEvent) {
        int ratingScore = (int)slider.getValue();
        ratingFromSlider.setText(String.valueOf(ratingScore));
    }

    public void returnToMainView(ActionEvent event){
        try {
            SceneSwitcher.switchToMain(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
