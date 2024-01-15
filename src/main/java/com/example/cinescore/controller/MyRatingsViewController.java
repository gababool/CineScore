package com.example.cinescore.controller;

import com.example.cinescore.model.UserManager;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class MyRatingsViewController implements Initializable {
    public TableView<String> showsTable;
    public Tab showsTab;
    public TableView moviesTable;
    public Tab moviesTab;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
