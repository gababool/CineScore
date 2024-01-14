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

public class StartingViewController {
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private Button createAccountButton;
    @FXML private Label createAccountLabel;
    @FXML private Label titleLabel;
    @FXML private Label subtitleLabel;
    @FXML private Button loginButton;

    private static final SceneSwitcher switcher = new SceneSwitcher();

    public void loginUser(ActionEvent event){
        CineScore cineScore = CineScoreApp.getCineScore();
        String username = usernameField.getText().trim();
        String password = passwordField.getText();
        try {
            User currentUser = cineScore.loginUser(username, password);
            UserManager.getInstance().setCurrentUser(currentUser);
            switcher.switchToMain(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void newUser(ActionEvent event) throws IOException{
        switcher.switchToCreateAccount(event);
    }

    @FXML
    public void handleKeyPress(KeyEvent event){
        switch(event.getCode()){
            case ENTER: loginButton.fire();
            case ESCAPE: Platform.exit();
        }
    }
}