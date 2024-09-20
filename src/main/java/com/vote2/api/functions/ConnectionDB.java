package com.vote2.api.functions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public Connection getConnectionDB(String url, String username, String password) {
        Connection connection = null;
        try {
            // Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Create the connection
            connection = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
