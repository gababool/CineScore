package com.example.cinescore.controller;

import com.example.cinescore.model.Movie;
import com.example.cinescore.model.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MyRatingsViewController implements Initializable {
    public TableView<Movie> moviesTable;
    public TableColumn<Movie, String> movieTitleColumn;
    public TableColumn<Movie, String> movieDirectorColumn;
    public TableColumn<Movie, Integer> myMovieRatingColumn;
    public TableColumn<Movie, Integer> avgMovieRatingColumn;
    public Button goToMediaButton;

    public Label titleLabel;
    public Button updateRatingButton;
    public Button returnButton;
    public TextField searchField;
    public Button searchButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void goToMediaPage(ActionEvent event) {
    }

    public void updateRating(ActionEvent event) {
    }

    public void returnToMainPage(ActionEvent event) {
    }
}
