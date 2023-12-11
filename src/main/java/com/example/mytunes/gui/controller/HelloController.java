package com.example.mytunes.gui.controller;

import com.example.mytunes.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable
{
    public Button playlistNewButton;
    public Button playlistEditButton;
    public Button playlistDeleteButton;
    public Button songsInPlaylistDeleteButton;
    public Button songsDeleteButton;
    public Button songEditButton;
    public Button songNewButton;
    public Slider volumeControlSlider;
    public Slider songTimeSlider;
    public Label lblSongTimeSinceStart;
    public Label lblSongTimeSinceStart1;
    public Label currentSongsLabel;
    @FXML
    private Label welcomeText;


    @FXML
    public void playlistNewButtonAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("new-playlist.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    @FXML
    public void playlistEditButtonAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Playlist-edit.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);

    }
    @FXML
    public void deleteButtonAction(ActionEvent event) {
    }
    @FXML
    public void songEditButtonAction(ActionEvent event) throws IOException {FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AllSongs-edit.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    @FXML
    public void songNewButtonAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("new-song.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}