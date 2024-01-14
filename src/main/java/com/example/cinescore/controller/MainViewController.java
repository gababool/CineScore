package com.example.cinescore.controller;

import com.example.cinescore.model.User;
import com.example.cinescore.model.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
    public Button rateMenuButton;
    public Button myRatingsMenuButton;
    public Button watchlistMenuButton;
    public Button logoutButton;
    public Button searchButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loggedInUser.setText("Logged in as: " + UserManager.getInstance().getCurrentUser().getUsername());
    }
}
