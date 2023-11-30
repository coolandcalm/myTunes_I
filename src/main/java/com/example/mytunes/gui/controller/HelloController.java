package com.example.mytunes.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class HelloController {
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
    public void playlistNewButtonAction(ActionEvent event) {
    }
    @FXML
    public void playlistEditButtonAction(ActionEvent event) {
    }
    @FXML
    public void deleteButtonAction(ActionEvent event) {
    }
    @FXML
    public void songEditButtonAction(ActionEvent event) {
    }
    @FXML
    public void songNewButtonAction(ActionEvent event) {
    }
}