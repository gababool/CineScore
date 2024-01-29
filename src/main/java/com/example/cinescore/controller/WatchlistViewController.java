package com.example.cinescore.controller;

import com.example.cinescore.CineScoreApp;
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
import java.util.*;

public class WatchlistViewController implements Initializable {
    public Button searchButton;
    public Button returnButton;

    public Label titleLabel;
    public TextField titleSearchField;
    public Button goToMoviePageButton;
    public Button rateMovieButton;
    public ImageView moviePoster;
    public Label movieTitleLabel;
    public Label movieDirectorLabel;
    public Label movieReleaseYearLabel;
    public Label movieWriterLabel;
    public Label moviePlotLabel;
    public TableView<Movie> watchlistTable;
    public TableColumn<Movie, String> movieTitleColumn;
    public TableColumn<Movie, String> avgRatingColumn;
    public TableColumn<Movie, String> myRatingColumn;
    public Button removeFromWatchlistButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Movie> movies = UserManager.getInstance().getCurrentUser().retrieveWatchlistAsList();
        watchlistTable.getItems().addAll(movies);
        movieTitleColumn.setCellValueFactory(new PropertyValueFactory<>("fullTitle"));
        avgRatingColumn.setCellValueFactory(new PropertyValueFactory<>("avgRating"));
        myRatingColumn.setCellValueFactory(new PropertyValueFactory<>("userRating"));

        watchlistTable.getSelectionModel().selectedItemProperty().addListener((observable, oldMovie, newMovie) -> {
            if (newMovie != null) {
                updateDisplay(newMovie);
            }
        });

    }
    private void updateDisplay(Movie movie){
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

    public void returnToMainPage(ActionEvent event) {
        try {
            SceneSwitcher.switchToMain(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchMovie(ActionEvent event) {
    }

    public void goToMoviePage(ActionEvent event) {
    }

    public void rateMovie(ActionEvent event) {
    }

    public void removeFromWatchlist(ActionEvent event) {
    }
}
