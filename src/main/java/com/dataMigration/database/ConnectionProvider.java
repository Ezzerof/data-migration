package com.dataMigration.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {

    private static final String URL = "jdbc:mysql://localhost:3306/employeemigration";
    private static Connection connection;
    private static Properties properties = new Properties();

    private ConnectionProvider() {
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                properties.load(new BufferedReader(new FileReader("src\\main\\resources\\login.properties")));
                connection = DriverManager.getConnection(URL, properties.getProperty("username"), properties.getProperty("password"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
