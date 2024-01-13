package com.example.cinescore.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StartupViewController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}