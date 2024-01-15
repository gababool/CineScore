module com.example.cinescore {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;

    opens com.example.cinescore to javafx.fxml;
    exports com.example.cinescore;
    exports com.example.cinescore.controller;
    exports com.example.cinescore.model;
    opens com.example.cinescore.controller to javafx.fxml;
    opens com.example.cinescore.model to com.fasterxml.jackson.databind;
}