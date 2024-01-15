package com.example.cinescore.controller;

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
    public TableView resultsTable;
    public TableColumn titleColumn;
    public TableColumn avgRatingColumn;
    public TableColumn myRatingColumn;
    public TextField searchField;
    public CheckBox movieCheckbox;
    public CheckBox tvCheckbox;
    public Button myRatingsMenuButton;
    public Button watchlistMenuButton;
    public Button searchButton;
    public Button rateMovieMenuButton;
    public Button rateShowMenuButton;



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
}
