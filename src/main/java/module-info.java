module com.example.cinescore {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.cinescore to javafx.fxml;
    exports com.example.cinescore;
    exports com.example.cinescore.controller;
    opens com.example.cinescore.controller to javafx.fxml;
}