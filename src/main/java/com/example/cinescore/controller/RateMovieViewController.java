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
    public TextField titleField;
    public TextField releaseYearField;
    public Slider slider;
    public Label ratingFromSlider;
    public Button addRatingButton;
    public Button returnButton;
    public Button searchMovieButton;
    public ImageView moviePoster;
    public Label directorLabel;

    public void loadMovieInfo(Movie movie){
        titleField.setText(movie.getTitle());
        titleField.setEditable(false);
        directorLabel.setText(movie.getDirector());
        releaseYearField.setText(String.valueOf(movie.getReleaseYear()));
        releaseYearField.setEditable(false);
    }

    public void rateMovie(ActionEvent event){
        String title = titleField.getText().trim();
        String releaseYear = releaseYearField.getText().trim();
        int rating = (int)slider.getValue();
        CineScore cineScore = CineScoreApp.getCineScore();
        try {
            cineScore.addMovieRating(title, releaseYear, rating);
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

    public void searchMovie(ActionEvent event) {
        String title = titleField.getText().trim();
        String releaseYear = releaseYearField.getText().trim();
        Movie movie = MovieAPIService.retrieveMovieData(title, releaseYear);
        directorLabel.setText(movie.getDirector());
        directorLabel.setVisible(true);
        try{
            InputStream stream = new URL(movie.getPoster()).openStream();
            Image image = new Image(stream);
            moviePoster.setImage(image);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
