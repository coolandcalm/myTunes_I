package com.example.mytunes.gui.model;

import com.example.mytunes.businessEntities.Song;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.HashMap;

public class SongDataModel {

    HashMap<String, String> songs = new HashMap<String, String>();

    /*
    [
        {
            artist=Artist 1,
            time=2:28,
            title=Song 1,
            category=Metalcore
        },
        {
            artist=Artist 1,
            time=2:28,
            title=Song 1,
            category=Metalcore
        },
        {
            artist=Artist 1,
            time=2:28,
            title=Song 1,
            category=Metalcore
        },
        {
            artist=Artist 1,
            time=2:28,
            title=Song 1,
            category=Metalcore
        },
        {
            artist=Artist 1,
            time=2:28,
            title=Song 1,
            category=Metalcore
        }
    ]
     */

    public static void initSongsMap(){
        SongDataModel newSong = new SongDataModel();

        for (int i = 0; i < 5; i++) {
            newSong.setSongs();
        }

    }

    public void setSongs() {
        songs.put("title", "Song 1");
        songs.put("artist", "Artist 1");
        songs.put("category", "Metalcore");
        songs.put("time", "2:28");
        System.out.println(songs);
    }
}
