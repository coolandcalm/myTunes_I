package com.example.mytunes.dal;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {
    private SQLServerDataSource ds;

    public DBconnection(SQLServerDataSource ds) {
        this.ds = ds;
    }

    public void DBconnection() {
        ds = new SQLServerDataSource();
        ds.setDatabaseName("MyTunesCS25");
        ds.setUser("CSe2023b_e_25");
        ds.setPassword("CSe2023bE25#23");
        ds.setServerName("10.176.111.34");
        ds.setTrustServerCertificate(true);
        try (Connection con = ds.getConnection()) {
            String sql = "SELECT * FROM dbo.playlist";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}