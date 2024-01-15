package com.example.cinescore.controller;

import com.example.cinescore.model.Movie;
import com.example.cinescore.model.User;
import com.example.cinescore.model.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    @FXML public Label loggedInUser;
    public Label titleLabel;
    public Button friendsButton;
    public Button myAccountButton;
    public TextField searchField;
    public Button myRatingsMenuButton;
    public Button watchlistMenuButton;
    public Button searchButton;
    public Button rateMovieMenuButton;
    public Button rateShowMenuButton;
    public Tab movieTab;
    public TableView movieResultsTable;
    public TableColumn movieTitleColumn;
    public TableColumn movieAvgRatingColumn;
    public TableColumn myMovieRatingColumn;
    public Tab showTab;
    public TableView showResultsTable;
    public TableColumn showTitleColumn;
    public TableColumn avgShowRatingColumn;
    public TableColumn myShowRatingColumn;
    public Button goToMediaPageButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loggedInUser.setText("Logged in as: " + UserManager.getInstance().getCurrentUser().getUsername());
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

    public void goToMediaPage(ActionEvent event) {
    }
}
