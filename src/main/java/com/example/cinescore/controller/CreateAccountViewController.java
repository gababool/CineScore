package com.example.cinescore.controller;

import com.example.cinescore.CineScoreApp;
import com.example.cinescore.model.CineScore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreateAccountViewController {

    @FXML public Button cancelButton;
    @FXML public Label titleLabel;
    @FXML public Label messageLabel;
    @FXML private PasswordField passwordField;
    @FXML private TextField usernameField;
    @FXML private Button createAccountButton;

    public void createNewAccount(ActionEvent event) {
        CineScore cineScore = CineScoreApp.getCineScore();
        String username = usernameField.getText().trim();
        String password = passwordField.getText();
        try {
            cineScore.createUser(username, password);
        } catch (Exception e) {
            e.printStackTrace();
            messageLabel.setText(e.getMessage());
            messageLabel.setVisible(true);
        }
    }

    public void cancelAccountCreation(ActionEvent event) {
        try {
            SceneSwitcher.switchToStartingView(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
