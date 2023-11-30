package com.example.mytunes.businessEntities;

import java.util.Date;

public class Song
{
    public String title;
    public String artist;
    public String category;
    public Date time;

    public String file;

    public Song (String title,String artist,String category,Date time, String file)
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

    public Date getTime() {
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

    public void setTime(Date time) {
        this.time = time;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
