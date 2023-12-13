package com.example.mytunes.businessEntities;

public class Song
{
    public String title;
    public String artist;
    public String category;
    public String time;

    public String file;

    public Song (String title, String artist, String category, String time, String file)
    {
        this.title = title;
        this.artist = artist;
        this.category = category;
        this.time = time;
        this.file = file;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getTime() {
        return time;
    }

    public String getFile() {
        return file;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
