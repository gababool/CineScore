package com.example.cinescore.controller;

import com.example.cinescore.CineScoreApp;
import com.example.cinescore.model.CineScore;
import com.example.cinescore.model.Movie;
import com.example.cinescore.model.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class RateMovieViewController {
    public Label titleLabel;
    public TextField titleField;
    public TextField directorField;
    public TextField releaseYearField;
    public Slider slider;
    public Label ratingFromSlider;
    public Button addRatingButton;
    public Button returnButton;

    public void loadMovieInfo(Movie movie){
        titleField.setText(movie.getTitle());
        titleField.setEditable(false);
        directorField.setText(movie.getDirector());
        directorField.setEditable(false);
        releaseYearField.setText(String.valueOf(movie.getReleaseYear()));
        releaseYearField.setEditable(false);
    }

    public void rateMovie(ActionEvent event){
        String title = titleField.getText().trim();
        String director = directorField.getText().trim();
        int releaseYear = Integer.parseInt(releaseYearField.getText().trim());
        int rating = (int)slider.getValue();
        CineScore cineScore = CineScoreApp.getCineScore();
        cineScore.addMovieRating(title, director, releaseYear, rating);
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
