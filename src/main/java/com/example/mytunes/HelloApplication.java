package com.example.mytunes;

import com.example.mytunes.gui.model.SongDataModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 972, 665);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        SongDataModel.initSongsMap();
    }

    public static void main(String[] args) {
        launch();
    }
}