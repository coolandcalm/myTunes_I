package com.example.mytunes.bll;

import com.example.mytunes.businessEntities.Song;
import com.example.mytunes.businessEntities.Playlist;
import com.example.mytunes.dal.dao.DbDAOPlaylist;

import java.io.IOException;
import java.util.List;

public class PlaylistManager {
    private DbDAOPlaylist playlistDao;
    public PlaylistManager() throws IOException {
        playlistDao = new DbDAOPlaylist();
    }

    public List<Playlist> getAll() {
        return this.playlistDao.getAll();
    }
    public Playlist getById(int id) {
        return this.playlistDao.getById(id);
    }
    public Playlist create(Playlist playlist) {
        return this.playlistDao.create(playlist);
    }
    public Playlist update(Playlist playlist) {
        return this.playlistDao.update(playlist);
    }
    public void delete(Playlist playlist) {
        this.playlistDao.delete(playlist);
    }
    public Playlist assignSong(Playlist playlist, Song song, int order) {
        return this.playlistDao.assignSong(playlist, song, order);
    }
    public Playlist removeSong(int playlistId, int songId) {
        return this.playlistDao.removeSong(playlistId, songId);
    }
}
