package com.example.cinescore.controller;

import com.example.cinescore.CineScoreApp;
import com.example.cinescore.model.CineScore;
import com.example.cinescore.model.DataManager;
import com.example.cinescore.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreateAccountViewController {

    @FXML public Button cancelButton;
    @FXML private PasswordField passwordField;
    @FXML private TextField usernameField;
    @FXML private Button createAccountButton;
    @FXML private TextField emailField;
    private static final SceneSwitcher switcher = new SceneSwitcher();

    public User createNewAccount(ActionEvent event) {
        CineScore cineScore = CineScoreApp.getCineScore();
        String username = usernameField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText();
        User user = null;
        try {
            user = cineScore.createUser(username, email, password);
            switcher.switchToStartingView(event);
            DataManager.saveState(cineScore);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;

    }

    public void cancelAccountCreation(ActionEvent event) {
        try {
            switcher.switchToStartingView(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
