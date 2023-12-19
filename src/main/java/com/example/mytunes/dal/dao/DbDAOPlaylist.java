package com.example.mytunes.dal.dao;

import com.example.mytunes.businessEntities.Playlist;
import com.example.mytunes.businessEntities.Song;
import com.example.mytunes.dal.ConnectionManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbDAOPlaylist {
    private ConnectionManager dbConnection;
    public DbDAOPlaylist() throws IOException {
        this.dbConnection = new ConnectionManager();
    }

    public List<Playlist> getAll() {
        ArrayList<Playlist> playlists = new ArrayList<Playlist>();
        try(Connection con = dbConnection.getConnection())
        {
            String sql = "SELECT * FROM Playlist";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                int id = rs.getInt("Id");
                String playlistName = rs.getString("PlaylistName");
                Playlist thisPlaylist = new Playlist(id, playlistName, 0, "");

                ArrayList<Song> songs = getSongsForPlaylist(con, id);

                thisPlaylist.setSongs(songs);
                playlists.add(thisPlaylist);
            }
        }
        catch (SQLServerException sqlse)
        {
            System.out.println(sqlse);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return playlists;
    }

    private ArrayList<Song> getSongsForPlaylist(Connection con, int playlistId) throws SQLException {
        ArrayList<Song> songs = new ArrayList<>();

        // Assuming your linking table is named PlaylistSong and has columns PlaylistId and SongId
        String sql = "SELECT * FROM PlaylistSong WHERE PlaylistId = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, playlistId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int songId = rs.getInt("SongId");
                // Fetch song details using songId and add to the list
                //Song song = getSongById(con, songId);
                Song song = new Song(songId, "");
                songs.add(song);
            }
        }

        return songs;
    }
    public Playlist getById(int id) {
        try (Connection con = dbConnection.getConnection()) {
            String sql = "SELECT * FROM Playlist WHERE Id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    String playlistName = rs.getString("PlaylistName");
                    Playlist playlist = new Playlist(id, playlistName, 0, "");
                    return playlist;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Playlist create(Playlist playlist) {
        try (Connection con = dbConnection.getConnection()) {
            String sql = "INSERT INTO Playlist (PlaylistName) VALUES (?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, playlist.getName());
                pstmt.executeUpdate();

                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    playlist.setId(id);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return playlist;
    }

    public Playlist update(Playlist playlist) {
        try (Connection con = dbConnection.getConnection()) {
            String sql = "UPDATE Playlist SET PlaylistName = ? WHERE Id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, playlist.getName());
                pstmt.setInt(2, playlist.getId());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return playlist;
    }

    public void delete(Playlist playlist) {
        try (Connection con = dbConnection.getConnection()) {
            String sql = "DELETE FROM Playlist WHERE Id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, playlist.getId());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Playlist assignSong(Playlist playlist, Song song, int order) {
        try (Connection con = dbConnection.getConnection()) {
            // Check if the association already exists
            if (!isSongInPlaylist(con, song.songIdProperty().get(), playlist.getId())) {
                // If not, add the song to the playlist
                String sql = "INSERT INTO PlaylistSong (SongId, PlaylistId, \"Order\") VALUES (?, ?, ?)";
                try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                    pstmt.setInt(1, song.songIdProperty().get());
                    pstmt.setInt(2, playlist.getId());
                    pstmt.setInt(3, order);
                    pstmt.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return getById(playlist.getId()); // Return the updated playlist
    }

    public Playlist removeSong(int playlistId, int songId) {
        try (Connection con = dbConnection.getConnection()) {
            // Check if the association exists before attempting to remove
            if (isSongInPlaylist(con, songId, playlistId)) {
                String sql = "DELETE FROM PlaylistSong WHERE SongId = ? AND PlaylistId = ?";
                try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                    pstmt.setInt(1, songId);
                    pstmt.setInt(2, playlistId);
                    pstmt.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return getById(playlistId); // Return the updated playlist
    }

    private boolean isSongInPlaylist(Connection con, int songId, int playlistId) throws SQLException {
        // Check if the association exists
        String sql = "SELECT * FROM PlaylistSong WHERE SongId = ? AND PlaylistId = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, songId);
            pstmt.setInt(2, playlistId);
            return pstmt.executeQuery().next();
        }
    }
}
