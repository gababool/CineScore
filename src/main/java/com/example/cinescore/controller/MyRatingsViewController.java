package com.example.cinescore.controller;

import com.example.cinescore.CineScoreApp;
import com.example.cinescore.model.Movie;
import com.example.cinescore.model.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

public class MyRatingsViewController implements Initializable {
    public TableView<Movie> moviesTable;
    public TableColumn<Movie, String> movieTitleColumn;
    public TableColumn<Movie, String> movieDirectorColumn;
    public TableColumn<Movie, Integer> myMovieRatingColumn;
    public TableColumn<Movie, String> avgMovieRatingColumn;
    public Button goToMediaButton;

    public Label titleLabel;
    public Button updateRatingButton;
    public Button returnButton;
    public TextField searchField;
    public Button searchButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Movie> movies = UserManager.getInstance().getCurrentUser().retrieveRatedMoviesAsList();
        moviesTable.getItems().addAll(movies);
        movieTitleColumn.setCellValueFactory(new PropertyValueFactory<>("fullTitle"));
        movieDirectorColumn.setCellValueFactory(new PropertyValueFactory<>("director"));
        avgMovieRatingColumn.setCellValueFactory(new PropertyValueFactory<>("avgRating"));
        myMovieRatingColumn.setCellValueFactory(new PropertyValueFactory<>("userRating"));
    }

    public void updateRating(ActionEvent event) {
        Movie movie = moviesTable.getSelectionModel().getSelectedItem();
        if (movie != null){
            try {
                SceneSwitcher.switchToRateMovieView(event, movie);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void goToMediaPage(ActionEvent event) {
    }

    public void returnToMainPage(ActionEvent event) {
        try {
            SceneSwitcher.switchToMain(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
