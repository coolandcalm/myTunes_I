package com.example.mytunes.gui.controller;

import com.example.mytunes.businessEntities.Playlist;
import com.example.mytunes.bll.PlaylistManager;
import com.example.mytunes.gui.controller.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;

public class PlaylistController {
    @FXML
    public TextField nameTextField;
    private PlaylistManager playlistManager;
    private Playlist selectedPlaylist;
    @FXML
    private TableView<Playlist> playlistsTableView;
    private MainController mainController;

    public PlaylistController() throws IOException {
        this.playlistManager = new PlaylistManager();
    }

    public void setPlaylistsTableView(TableView<Playlist> playlistsTableView) {
        this.playlistsTableView = playlistsTableView;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void setSelectedPlaylist(Playlist selectedPlaylist) {
        this.selectedPlaylist = selectedPlaylist;
        nameTextField.setText(selectedPlaylist.getName());
    }
    @FXML
    public void btnSaveAction(ActionEvent actionEvent) {
        Playlist playlist = new Playlist(nameTextField.getText());
        this.playlistManager.create(playlist);
        closePlaylistWindow(actionEvent);
    }
    @FXML
    public void btnEditAction(ActionEvent actionEvent) {
        selectedPlaylist.setName(nameTextField.getText());
        this.playlistManager.update(selectedPlaylist);
        closePlaylistWindow(actionEvent);
    }
    @FXML
    public void btnDeleteAction(ActionEvent actionEvent) {
        this.playlistManager.delete(selectedPlaylist);
        closePlaylistWindow(actionEvent);
    }

    @FXML
    public void cancelButtonAction(ActionEvent actionEvent) {
        closePlaylistWindow(actionEvent);
    }

    private void closePlaylistWindow(ActionEvent actionEvent) {
        this.mainController.initializePlaylistTable();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
    private boolean showDeleteConfirmationDialog() {
        // You can customize this method to show a confirmation dialog
        // and return true if the user confirms the deletion, false otherwise.
        // For simplicity, we'll return true directly.
        return true;
    }
}
