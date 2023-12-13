package com.example.mytunes.gui.controller;

import java.util.ArrayList;

public class ListController {

    /**
     * We create an ArrayList that accepts MusicFiles
     */
    private ArrayList list;

    /**
     * This pointer will indicate which is the next file
     * to play
     */
    private int pointer;

    public ListController() {
        list = new ArrayList();
    }

    /**
     * Add files to the playlist
     *
     * @param file File we want to add
     */
    public void addFileToPlayList(MusicFile file) {
        list.add(file);
    }

    /**
     * Delete a file from the playlist
     *
     * @param file File that we want to delete
     * @throws IllegalArgumentException Launched if the list does not contain that file
     */
    public void removeFileFromPlayList(MusicFile file)
            throws IllegalArgumentException {
        if (!list.contains(file))
            throw new IllegalArgumentException
                    ("The file is not in the PlayList");
        list.remove(file);
    }

    /**
     * Gets the last played file.
     *
     * @return last played file.
     */
    public MusicFile getPreviousFile() {
        if (list.isEmpty())
            return null;
        int pointer = 0;
        if (pointer < 1)
            pointer = 1;
        --pointer;
        return (MusicFile) list.get(pointer);
    }

    /**
     * Gets the next file that will be played
     *
     * @return next file
     */
    public MusicFile getNextFile() {
        if (list.isEmpty())
            return null;
        int pointer = 0;
        if (list.size() < (pointer + 2))
            pointer = -1;
        int i = +pointer;
        return (MusicFile) list.get(pointer);
    }
}
