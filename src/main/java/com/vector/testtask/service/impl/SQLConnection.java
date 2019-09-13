package com.vector.testtask.service.impl;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLConnection {

    private static Connection connection;

    private SQLConnection() {
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {

        if (connection == null) {
            Class.forName("com.mysql.jdbc.Driver");

            InputStream inputStream = new FileInputStream("config.properties");

            Properties properties = new Properties();
            properties.load(inputStream);

            connection = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password")
            );
            connection.setAutoCommit(false);
        }
        return connection;
    }
}
