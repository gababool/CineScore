package com.example.cinescore.controller;

import com.example.cinescore.CineScoreApp;
import com.example.cinescore.model.CineScore;
import com.example.cinescore.model.DataManager;
import com.example.cinescore.model.User;
import com.example.cinescore.model.UserManager;
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
    @FXML private PasswordField passwordField;
    @FXML private TextField usernameField;
    @FXML private Button createAccountButton;
    @FXML private TextField emailField;

    public void createNewAccount(ActionEvent event) {
        CineScore cineScore = CineScoreApp.getCineScore();
        String username = usernameField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText();
        try {
            cineScore.createUser(username, email, password);
        } catch (Exception e) {
            e.printStackTrace();
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
