package com.example.cinescore.controller;

import com.example.cinescore.model.Movie;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class WatchlistViewController {
    public Button searchButton;
    public TableView<Movie> moviesTable;
    public TextField searchField;
    public Button returnButton;
    public Label titleLabel;
    public Button goToMediaButton;
    public TableColumn<Movie, String> movieTitleColumn;
    public TableColumn<Movie, String> movieDirectorColumn;
    public TableColumn<Movie, Integer> myMovieRatingColumn;
    public TableColumn<Movie, Double> avgMovieRatingColumn;

    public void goToMediaPage(ActionEvent event) {
    }

    public void returnToMainPage(ActionEvent event) {
    }
}
