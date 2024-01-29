package com.example.cinescore.controller;

import com.example.cinescore.CineScoreApp;
import com.example.cinescore.model.CineScore;
import com.example.cinescore.model.Movie;
import com.example.cinescore.model.MovieAPIService;
import com.example.cinescore.model.UserManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    public Label loggedInUser;

    public Label titleLabel;
    public Button myAccountButton;
    public Button myRatingsMenuButton;
    public Button searchButton;
    public Button goToMoviePageButton;
    public Button goToWatchlistButton;
    public Button rateMovieButton;
    public Button logoutButton;
    public TextField titleSearchField;
    public Label movieTitleLabel;
    public Label movieDirectorLabel;
    public Label movieReleaseYearLabel;
    public Label movieWriterLabel;
    public Label moviePlotLabel;
    public TextField releaseYearSearchField;
    public ImageView moviePoster;
    public static Movie currentMovie = null;
    public Button watchlistMenuButton1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loggedInUser.setText("Logged in as: " + UserManager.getInstance().getCurrentUser().getUsername());
    }

    public void goToMyRatings(ActionEvent event) {
        try {
            SceneSwitcher.switchToMyRatingsView(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logOutUser(ActionEvent event) {
        UserManager.getInstance().setCurrentUser(null);
        try {
            SceneSwitcher.switchToStartingView(event);
        } catch (IOException e) {
            e.printStackTrace();
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

    public void addToAWatchlist(ActionEvent event) {
        CineScore cineScore = CineScoreApp.getCineScore();
        if (currentMovie != null) {
            cineScore.addMovieToWatchlist(currentMovie);
        }
    }

    public void goToMoviePage(ActionEvent event) {
    }

    public void goToWatchlist(ActionEvent event) {
        try{
            SceneSwitcher.switchToMyWatchlistView(event);
        }catch (Exception e){
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

    public void searchMovie(ActionEvent event) {
        String title = titleSearchField.getText().trim();
        String releaseYear = releaseYearSearchField.getText().trim();
        Movie movie = null;
        if (releaseYear.isBlank()) {
            movie = MovieAPIService.retrieveMovieFromTitleOnly(title);
        } else {
            movie = MovieAPIService.retrieveMovieFromTitleAndYear(title, releaseYear);
        }
        try {
            InputStream stream = new URL(movie.getPoster()).openStream();
            Image image = new Image(stream);
            moviePoster.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        movieTitleLabel.setText(movie.getTitle());
        movieDirectorLabel.setText("Director: "+movie.getDirector());
        movieWriterLabel.setText("Writer(s): "+movie.getWriter());
        movieReleaseYearLabel.setText("Release Year: "+movie.getReleaseYear());
        moviePlotLabel.setText(movie.getPlot());
        currentMovie = movie;
    }
}

