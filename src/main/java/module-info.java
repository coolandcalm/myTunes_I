module com.example.mytunes {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.microsoft.sqlserver.jdbc;
    requires java.sql;


    opens com.example.mytunes to javafx.fxml;
    exports com.example.mytunes;
    exports com.example.mytunes.gui.controller;
    opens com.example.mytunes.gui.controller to javafx.fxml;
}