package com.example.cinescore.controller;

import com.example.cinescore.CineScoreApp;
import com.example.cinescore.model.CineScore;
import com.example.cinescore.model.User;
import com.example.cinescore.model.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MyAccountViewController implements Initializable {
    public PasswordField passwordField;
    public TextField usernameField;
    public Label titleLabel;
    public Button updateInfoButton;
    public Button returnButton;
    public Label messageLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        User user = UserManager.getInstance().getCurrentUser();
        usernameField.setText(user.getUsername());
    }

    public void updateInfo(ActionEvent event) {
        User user = UserManager.getInstance().getCurrentUser();
        CineScore cineScore = CineScoreApp.getCineScore();
        if (!usernameField.getText().equals(user.getUsername())){
            try {
                cineScore.changeUsername(usernameField.getText().trim());
            } catch (Exception e) {
                e.printStackTrace();
                messageLabel.setText(e.getMessage());
                messageLabel.setVisible(true);
            }
        }
        else if (!passwordField.getText().equals(user.getUsername())){
            try {
                cineScore.changePassword(passwordField.getText().trim());
            } catch (Exception e) {
                e.printStackTrace();
                messageLabel.setText(e.getMessage());
                messageLabel.setVisible(true);
            }
        }
    }

    public void returnToMain(ActionEvent event) {
        try {
            SceneSwitcher.switchToMain(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
