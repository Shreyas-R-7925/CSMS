package com.cars24.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.cars24.config.DbConfig;

public class DbUtil {
    private static Connection connection;

    public static Connection getDbConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(DbConfig.host, DbConfig.username, DbConfig.password);
                System.out.println("Connected to database!");
            }
            return connection;
        } catch (SQLException e) {
            System.out.println("Error connecting to the database!");
            e.printStackTrace(); // Optionally, print the stack trace for debugging
            return null; // Return null if the connection fails
        }
    }

    // public void closeConnection() {
    //     try {
    //         if (connection != null && !connection.isClosed()) {
    //             connection.close();
    //             System.out.println("Connection closed!");
    //         }
    //     } catch (SQLException e) {
    //         System.out.println("Error closing the database connection!");
    //         e.printStackTrace();
    //     }
    // }
}
