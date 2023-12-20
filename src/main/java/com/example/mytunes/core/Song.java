package com.example.mytunes.core;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Song {


    private StringProperty title;
    private StringProperty artist;
    private StringProperty category;
    private StringProperty time;
    private StringProperty filePath;
    private IntegerProperty songId;

    public Song(int id, String name) {
        this.songId = new SimpleIntegerProperty(id);
        this.title = new SimpleStringProperty(name);
    }

    public Song(String title, String artist, String genre, String time) {
        this.title = new SimpleStringProperty(title);
        this.artist = new SimpleStringProperty(artist);
        this.category = new SimpleStringProperty(genre);
        this.time = new SimpleStringProperty(time);
    }

    public Song(int songId, String title, String artist, String genre, String time, String filePath) {
        this.songId = new SimpleIntegerProperty(songId);
        this.title = new SimpleStringProperty(title);
        this.artist = new SimpleStringProperty(artist);
        this.category = new SimpleStringProperty(genre);
        this.time = new SimpleStringProperty(time);
        this.filePath = new SimpleStringProperty(filePath);
    }

    public Song(String title, String artist, String genre, String time, String filePath) {
        this.title = new SimpleStringProperty(title);
        this.artist = new SimpleStringProperty(artist);
        this.category = new SimpleStringProperty(genre);
        this.time = new SimpleStringProperty(time);
        this.filePath = new SimpleStringProperty(filePath);
    }

    public Song(String title, String artist, String genre) {
        this.title = new SimpleStringProperty(title);
        this.artist = new SimpleStringProperty(artist);
        this.category = new SimpleStringProperty(genre);
    }

    public IntegerProperty songIdProperty(){
        return songId;
    }
    public StringProperty titleProperty() {
        return title;
    }

    public StringProperty artistProperty() {
        return artist;
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public StringProperty timeProperty() {
        return time;
    }
    public StringProperty filePathProperty() {
        return filePath;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public void setArtist(String artist) {
        this.artist.set(artist);
    }

    public void setCategory(String genre) {
        this.category.set(genre);
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public String getFilePath() {
        return filePath.get();
    }

    @Override
    public String toString() {
        return "Song{" +
                "title=" + title.get() +
                ", artist=" + artist.get() +
                ", category=" + category.get() +
                ", time=" + time.get() +
                '}';
    }
}