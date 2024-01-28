package com.example.cinescore.controller;

import com.example.cinescore.CineScoreApp;
import com.example.cinescore.model.Movie;
import com.example.cinescore.model.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;

public class WatchlistViewController implements Initializable {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HashSet<Movie> watchlist = UserManager.getInstance().getCurrentUser().getWatchlist();
        moviesTable.getItems().addAll(watchlist);
        movieTitleColumn.setCellValueFactory(new PropertyValueFactory<>("fullTitle"));
        movieDirectorColumn.setCellValueFactory(new PropertyValueFactory<>("director"));
        avgMovieRatingColumn.setCellValueFactory(new PropertyValueFactory<>("avgRating"));
        myMovieRatingColumn.setCellValueFactory(new PropertyValueFactory<>("userRating"));
    }

    public void goToMediaPage(ActionEvent event) {
    }

    public void returnToMainPage(ActionEvent event) {
    }
}
