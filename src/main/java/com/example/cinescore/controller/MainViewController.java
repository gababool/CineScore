package com.example.cinescore.controller;

import com.example.cinescore.CineScoreApp;
import com.example.cinescore.model.CineScore;
import com.example.cinescore.model.Movie;
import com.example.cinescore.model.UserManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    public Label loggedInUser;

    public Label titleLabel;
    public Button myAccountButton;
    public TextField searchField;
    public Button myRatingsMenuButton;
    public Button watchlistMenuButton;
    public Button searchButton;
    public Button rateMovieMenuButton;
    public TableView<Movie> movieResultsTable;
    public TableColumn<Movie, String> movieTitleColumn;
    public TableColumn<Movie, String> directorColumn;
    public TableColumn<Movie, Double> movieAvgRatingColumn;
    public TableColumn<Movie, Integer> myMovieRatingColumn;
    public Button goToMoviePageButton;
    public Button watchlistMenuButton1;
    public Button rateMovieTableButton;
    public Button logoutButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loggedInUser.setText("Logged in as: " + UserManager.getInstance().getCurrentUser().getUsername());
        Map<String, Movie> movies = CineScoreApp.getCineScore().getMovies();
        movieResultsTable.getItems().addAll(movies.values());
        movieTitleColumn.setCellValueFactory(new PropertyValueFactory<>("fullTitle"));
        directorColumn.setCellValueFactory(new PropertyValueFactory<>("director"));
        movieAvgRatingColumn.setCellValueFactory(new PropertyValueFactory<>("avgRating"));
        myMovieRatingColumn.setCellValueFactory(new PropertyValueFactory<>("userRating"));
    }


    public void goToRateMovie(ActionEvent event){
        try {
            SceneSwitcher.switchToRateMovieView(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToMyRatings(ActionEvent event){
        try {
            SceneSwitcher.switchToMyRatingsView(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logOutUser(ActionEvent event) {

    }

    public void rateMovieFromTable(ActionEvent event) {
        Movie movie = movieResultsTable.getSelectionModel().getSelectedItem();
        if (movie != null){
            try {
                SceneSwitcher.switchToRateMovieView(event, movie);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addToAWatchlist(ActionEvent event) {
        Movie movie = movieResultsTable.getSelectionModel().getSelectedItem();
        CineScore cineScore = CineScoreApp.getCineScore();
        if (movie != null){
            cineScore.addMovieToWatchlist(movie);
        }
    }

    public void goToMoviePage(ActionEvent event) {
    }

    public void updateTableFromSearch(ActionEvent event) {
    }

    public void goToWatchlist(ActionEvent event) {
        try {
            SceneSwitcher.switchToMyWatchlistView(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToMyAccount(ActionEvent event) {
        try {
            SceneSwitcher.switchToMyAccountView(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
