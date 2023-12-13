package com.example.mytunes.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnection {
    private final SQLServerDataSource dataSource;

    public DataBaseConnection()
    {
        dataSource = new SQLServerDataSource();
        dataSource.setServerName("10.176.111.34");
        dataSource.setDatabaseName("mytunessam");
        dataSource.setUser("CSe2023b_e_25");
        dataSource.setPassword("CSe2023bE25#23");
        dataSource.setTrustServerCertificate(true);
    }

    public Connection getConnection() throws SQLServerException {
        return dataSource.getConnection();
    }

    public static void main(String[] args) throws SQLException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();

        System.out.println("Try to open tho " + !connection.isClosed());

        connection.close();
    }
}