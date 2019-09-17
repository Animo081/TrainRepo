package com.vector.testtask.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLConnection {

    private static Connection connection;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public Connection getConnection() throws ClassNotFoundException, SQLException, IOException {

        if (connection == null) {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(
                    url,
                    username,
                    password
            );
            connection.setAutoCommit(false);
        }
        return connection;
    }
}
