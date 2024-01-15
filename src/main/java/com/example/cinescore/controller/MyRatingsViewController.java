package com.example.cinescore.controller;

import com.example.cinescore.model.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MyRatingsViewController implements Initializable {
    public TableView<String> showsTable;
    public Tab showsTab;
    public TableView moviesTable;
    public Tab moviesTab;
    public TableColumn movieTitleColumn;
    public TableColumn movieDirectorColumn;
    public TableColumn myMovieRatingColumn;
    public TableColumn avgMovieRatingColumn;
    public TableColumn showTitleColumn;
    public TableColumn myShowRatingColumn;
    public TableColumn avgShowRatingColumn;
    public Button goToMediaButton;
    public Label titleLabel;
    public Button updateRatingButton;
    public Button returnButton;
    public TextField searchField;
    public Button searchButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void goToMediaPage(ActionEvent event) {
    }

    public void updateRating(ActionEvent event) {
    }

    public void returnToMainPage(ActionEvent event) {
    }
}
