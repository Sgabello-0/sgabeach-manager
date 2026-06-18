package com.sgabello.sgabeachmanager.databasemanagers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AuthManager {

    private static Connection connection;

    public static void connetti(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:spiaggia.db");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void disconnetti(){
        try {
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
