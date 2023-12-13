package com.example.mytunes.gui.controller;

import com.example.mytunes.businessEntities.Song;

import java.util.ArrayList;
import java.util.List;

public class SongDataModel {

    List<Song> songs;

    public SongDataModel() {
        songs = new ArrayList<>();
    }

    public static void main(String[] args) {
        initSongsList();
    }

    public static void initSongsList() {
        SongDataModel songDataModel = new SongDataModel();

        for (int i = 0; i < 5; i++) {
            songDataModel.addSong("Song " + (i + 1), "Artist " + (i + 1), "Metalcore", null, "file" + i + ".mp3");
        }

        songDataModel.printSongs();
    }

    public void addSong(String title, String artist, String category, String time, String file) {
        Song newSong = new Song(title, artist, category, time, file);
        songs.add(newSong);
    }

    public void printSongs() {
        for (Song song : songs) {
            System.out.println(song);
        }
    }
}
