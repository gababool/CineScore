package com.example.cinescore;

import com.example.cinescore.model.CineScore;
import com.example.cinescore.model.DataManager;
import com.example.cinescore.model.UserManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CineScoreApp extends Application {
    public static CineScore cineScore;

    public static CineScore getCineScore() {
        return cineScore;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CineScoreApp.class.getResource("starting-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("CineScore");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        cineScore = DataManager.loadState();
        UserManager.getInstance();
        launch();
    }
}
