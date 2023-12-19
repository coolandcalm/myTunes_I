package com.example.mytunes.gui.controller;

import com.example.mytunes.HelloApplication;
import com.example.mytunes.businessEntities.Playlist;
import com.example.mytunes.bll.PlaylistManager;
import com.example.mytunes.businessEntities.PlaylistSong;
import com.example.mytunes.businessEntities.Song;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable
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
    public TableView<Playlist> playlistsTableView;
    @FXML
    public TableView<Song> allSongsTableView;
    @FXML
    public Button moveSongToPlaylistButton;
    public ListView<PlaylistSong> songsInPlaylistListView;
    @FXML
    private TableColumn<Playlist, String> playlistNameColumn;
    @FXML
    private TableColumn<Playlist, Integer> totalSongsColumn;
    public TableColumn totalTimeColumn;


    @FXML
    private Label welcomeText;

    private PlaylistManager playlistManager;

    public MainController() throws IOException {
        playlistManager = new PlaylistManager();
    }

    @FXML
    public void playlistNewButtonAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("new-playlist.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        PlaylistController playlistController = fxmlLoader.getController();
        playlistController.setMainController(this);
    }
    @FXML
    public void playlistEditButtonAction(ActionEvent event) throws IOException {
        if (getSelectedPlaylist() == null)
            return;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("edit-playlist.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        PlaylistController playlistController = fxmlLoader.getController();
        playlistController.setSelectedPlaylist(getSelectedPlaylist());
        playlistController.setMainController(this);
    }


    @FXML
    public void deleteButtonAction(ActionEvent event) throws IOException {
        if (getSelectedPlaylist() == null)
            return;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("delete-playlist.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Delete");  
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        PlaylistController playlistController = fxmlLoader.getController();
        playlistController.setSelectedPlaylist(getSelectedPlaylist());
        playlistController.setMainController(this);
    }
    @FXML
    public void songEditButtonAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AllSongs-edit.fxml"));
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
        initializePlaylistTable();
    }

    public Playlist getSelectedPlaylist() {
        int selectedIndex = playlistsTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            return playlistsTableView.getItems().get(selectedIndex);
        } else {
            return null;
        }
    }
    public Song getSelectedSong() {
        int selectedIndex = allSongsTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            return allSongsTableView.getItems().get(selectedIndex);
        } else {
            return null;
        }
    }


    @FXML
    public void initializePlaylistTable() {
        // Set up the cell value factories for each column
        playlistNameColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getName()));
        totalSongsColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getHowManySongs()));

        // Load playlists data and populate the TableView
        playlistsTableView.setItems(FXCollections.observableList(playlistManager.getAll()));
    }

    public void playlistDeleteButtonAction(ActionEvent actionEvent) throws IOException {
        if (getSelectedPlaylist() == null)
            return;
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("delete-playlist.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Delete Playlist?");
        stage.setScene(scene);
        stage.show();

        PlaylistController playlistController = loader.getController();
        playlistController.setSelectedPlaylist(getSelectedPlaylist());
        playlistController.setMainController(this);
    }

    public void moveSongtoPlaylist(ActionEvent actionEvent) {
        if (getSelectedPlaylist() == null || getSelectedSong() == null)
            return;
        playlistManager.assignSong(getSelectedPlaylist(),getSelectedSong(),1);
    }

    public void removeSongButtonAction(ActionEvent actionEvent) {
        var selectedSong = songsInPlaylistListView.getSelectionModel().getSelectedItem();
        if (selectedSong == null)
            return;
        playlistManager.removeSong(selectedSong.getPlaylistId(), selectedSong.getSongId());
    }
}