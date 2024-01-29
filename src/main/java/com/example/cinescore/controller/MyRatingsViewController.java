package com.example.cinescore.controller;

import com.example.cinescore.CineScoreApp;
import com.example.cinescore.model.CineScore;
import com.example.cinescore.model.Movie;
import com.example.cinescore.model.UserManager;
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
import java.util.ResourceBundle;

public class MyRatingsViewController implements Initializable {

    public Label titleLabel;
    public Button returnButton;
    public Button searchButton;
    public TextField titleSearchField;
    public Button goToMoviePageButton;
    public Button addToWatchlistButton;
    public Button rateMovieButton;
    public ImageView moviePoster;
    public Label movieTitleLabel;
    public Label movieDirectorLabel;
    public Label movieReleaseYearLabel;
    public Label movieWriterLabel;
    public Label moviePlotLabel;
    public TableView<Movie> ratingsTable;
    public TableColumn<Movie, Double> avgRatingColumn;
    public TableColumn<Movie, String> myRatingColumn;
    public TableColumn<Movie, String> movieTitleColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Movie> movies = UserManager.getInstance().getCurrentUser().retrieveRatedMoviesAsList();
        ratingsTable.getItems().addAll(movies);
        movieTitleColumn.setCellValueFactory(new PropertyValueFactory<>("fullTitle"));
        avgRatingColumn.setCellValueFactory(new PropertyValueFactory<>("avgRating"));
        myRatingColumn.setCellValueFactory(new PropertyValueFactory<>("userRating"));

        ratingsTable.getSelectionModel().selectedItemProperty().addListener((observable, oldMovie, newMovie) -> {
            if (newMovie != null) {
                updateDisplay(newMovie);
            }
        });
    }

    public void updateDisplay(Movie movie){
        movieTitleLabel.setText(movie.getTitle());
        movieDirectorLabel.setText("Director: "+movie.getDirector());
        movieWriterLabel.setText("Writer(s): "+movie.getWriter());
        movieReleaseYearLabel.setText("Release Year: "+movie.getReleaseYear());
        moviePlotLabel.setText(movie.getPlot());
        try {
            InputStream stream = new URL(movie.getPoster()).openStream();
            Image image = new Image(stream);
            moviePoster.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rateMovie(ActionEvent event) {
        Movie movie = ratingsTable.getSelectionModel().getSelectedItem();
        if (movie != null){
            try {
                SceneSwitcher.switchToRateMovieView(event, movie);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addToAWatchlist(ActionEvent event) {
        Movie movie = ratingsTable.getSelectionModel().getSelectedItem();
        if (movie != null){
            try {
                CineScore cineScore = CineScoreApp.getCineScore();
                cineScore.addMovieToWatchlist(movie);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void returnToMain(ActionEvent event) {
        try {
            SceneSwitcher.switchToMain(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToMoviePage(ActionEvent event) {
    }

    public void searchMovie(ActionEvent event) {
    }
}
