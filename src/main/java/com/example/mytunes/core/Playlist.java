package com.example.mytunes.core;

import com.example.mytunes.businessEntities.Song;

import java.util.ArrayList;

public class Playlist {
    private int id;
    private String name;
    private int howManySongs;
    private String totalReproductionTime;
    private ArrayList<Song> songs;

    public Playlist(String name) {
        this.name = name;
    }
    public Playlist(int id, String name, int howManySongs, String totalReproductionTime) {
        this.id = id;
        this.name = name;
        this.howManySongs = howManySongs;
        this.totalReproductionTime = totalReproductionTime;
        this.songs = new ArrayList<Song>();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHowManySongs() {
        return this.songs.size();
    }

    public String getTotalReproductionTime() {
        return totalReproductionTime;
    }

    public void setTotalReproductionTime(String totalReproductionTime) {
        this.totalReproductionTime = totalReproductionTime;
    }

    @Override
    public String toString() {
        return id + "  " +
                name + "  " +
                howManySongs + "  " +
                totalReproductionTime;
    }
}
