package com.example.cinescore.controller;

import com.example.cinescore.CineScoreApp;
import com.example.cinescore.model.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitcher {

    private static Stage stage;
    private static Scene scene;
    private static Parent root;
    private static FXMLLoader fxmlLoader;

    public SceneSwitcher(){}

    private static void prepareScene(ActionEvent event, String filePath) throws IOException {
        fxmlLoader = new FXMLLoader(SceneSwitcher.class.getResource(filePath));
        root = fxmlLoader.load();
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    public static void switchToMain(ActionEvent event) throws IOException {
        String filePath = "/com/example/cinescore/main-view.fxml";
        prepareScene(event, filePath);
    }

    public static void switchToCreateAccount(ActionEvent event) throws IOException{
        String filepath = "/com/example/cinescore/create-account-view.fxml";
        prepareScene(event,  filepath);
    }

    public static void switchToStartingView(ActionEvent event) throws IOException{
        String filepath = "/com/example/cinescore/starting-view.fxml";
        prepareScene(event,  filepath);
    }

    public static void switchToRateMovieView(ActionEvent event, Movie movie) throws IOException{
        String filepath = "/com/example/cinescore/rate-movie-view.fxml";
        prepareScene(event,  filepath);

        RateMovieViewController rateMovieViewController = fxmlLoader.getController();
        rateMovieViewController.loadMovieInfo(movie);
    }

    public static void switchToMoviePage(ActionEvent event, Movie movie) throws IOException{
        String filepath = "/com/example/cinescore/rate-movie-view.fxml";
        prepareScene(event,  filepath);

        MoviePageViewController moviePageViewController = fxmlLoader.getController();
        moviePageViewController.loadMovieInfo(movie);
    }

    public static void switchToMyRatingsView(ActionEvent event) throws IOException{
        String filepath = "/com/example/cinescore/my-ratings-view.fxml";
        prepareScene(event,  filepath);
    }

    public static void switchToMyWatchlistView(ActionEvent event) throws IOException{
        String filepath = "/com/example/cinescore/watchlist-view.fxml";
        prepareScene(event,  filepath);
    }

    public static void switchToMyAccountView(ActionEvent event) throws IOException{
        String filepath = "/com/example/cinescore/my-account.view.fxml";
        prepareScene(event,  filepath);
    }

    public static void logout(ActionEvent event){
        stage.close();
    }

}
