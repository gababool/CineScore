package com.example.cinescore.controller;

import com.example.cinescore.CineScoreApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitcher {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public SceneSwitcher(){}

    private void prepareScene(ActionEvent event, Parent root, String filePath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(filePath));
        root = fxmlLoader.load();
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    public void switchToMain(ActionEvent event) throws IOException {
        String filePath = "/com/example/cinescore/main-view.fxml";
        prepareScene(event, root, filePath);
    }

    public void switchToCreateAccount(ActionEvent event) throws IOException{
        String filepath = "/com/example/cinescore/create-account-view.fxml";
        prepareScene(event, root, filepath);
    }

    public void switchToStartingView(ActionEvent event) throws IOException{
        String filepath = "/com/example/cinescore/starting-view.fxml";
        prepareScene(event, root, filepath);
    }

}
