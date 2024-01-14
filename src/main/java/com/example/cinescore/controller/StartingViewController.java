package com.example.cinescore.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class StartingViewController {
    public TextField usernameField;
    public TextField passwordField;
    public Button createAccountButton;
    public Label createAccountLabel;
    public Label titleLabel;
    public Label subtitleLabel;
    public Button loginButton;

    private static final SceneSwitcher switcher = new SceneSwitcher();

    public void loginUser(ActionEvent event) throws IOException {
        switcher.switchToMain(event);
    }

    public void newUser(ActionEvent event) throws IOException{
        switcher.switchToCreateAccount(event);
    }
}