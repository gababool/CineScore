package com.example.cinescore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CineScoreApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CineScoreApp.class.getResource("starting-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("CineScore: Rate your favorite shows and movies!");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}