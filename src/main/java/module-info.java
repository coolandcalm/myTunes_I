module com.example.mytunes {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.microsoft.sqlserver.jdbc;
    requires java.sql;
    requires java.naming;

    opens com.example.mytunes.ui to javafx.fxml;
    exports com.example.mytunes.ui;
    opens com.example.mytunes.ui.controllers to javafx.fxml;
    exports com.example.mytunes.ui.controllers;
}