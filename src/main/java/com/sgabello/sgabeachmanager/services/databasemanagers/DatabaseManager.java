package com.sgabello.sgabeachmanager.services.databasemanagers;

import com.sgabello.sgabeachmanager.modules.Client;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {

    private static Connection connection;

    public static void connect(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:beachData.db");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect(){
        try {
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTablesIfNotExist(){
        String sql_clients = """
                CREATE TABLE IF NOT EXISTS clients (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            firstname TEXT,
            lastname TEXT,
            phone TEXT,
            notes TEXT
        )
        """;

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql_clients);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Client> getClientList(){
        ArrayList<Client> clients = new ArrayList<>();
        String sql = "SELECT id, firstname, lastname, phone, notes FROM clients";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String fisrtname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String phone = resultSet.getString("phone");
                String notes = resultSet.getString("notes");
                clients.add(new Client(id, fisrtname, lastname, phone, notes));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
