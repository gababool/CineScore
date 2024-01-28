package com.example.cinescore.controller;

import com.example.cinescore.CineScoreApp;
import com.example.cinescore.model.CineScore;
import com.example.cinescore.model.User;
import com.example.cinescore.model.UserManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.util.Objects;

public class StartingViewController {
    public Label messageLabel;
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private Button createAccountButton;
    @FXML private Label createAccountLabel;
    @FXML private Label titleLabel;
    @FXML private Label subtitleLabel;
    @FXML private Button loginButton;

    public void loginUser(ActionEvent event){
        String username = usernameField.getText().trim();
        String password = passwordField.getText();
        try {
            CineScore cineScore = CineScoreApp.getCineScore();
            User currentUser = cineScore.loginUser(username, password);
            UserManager.getInstance().setCurrentUser(currentUser);
            SceneSwitcher.switchToMain(event);
        } catch (Exception e) {
            e.printStackTrace();
            messageLabel.setText(e.getMessage());
            messageLabel.setVisible(true);
        }
    }

    public void newUser(ActionEvent event) throws IOException{
        SceneSwitcher.switchToCreateAccount(event);
    }

    @FXML
    public void handleKeyPress(KeyEvent event){
        if (Objects.requireNonNull(event.getCode()) == KeyCode.ENTER) {
            loginButton.fire();
        }
    }
}