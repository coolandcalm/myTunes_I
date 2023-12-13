package com.example.mytunes.gui.controller;

public class MusicFile {

    private String name;
    private String path;

    public MusicFile(String name, String path) {
        name = name;
        path = path;
    }

    public void setName(String name) {
        name = name;
    }

    public String getName() {
        return name;
    }

    public void setPath(String path) {
        path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "File: " + name;
    }

}
