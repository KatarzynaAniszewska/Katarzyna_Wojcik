package com.kodilla.jdbc;

import sun.rmi.transport.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbManager {
    private java.sql.Connection conn;
    private static DbManager dbManagerInstance;

    private DbManager()throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("User", "kodilla_user");
        connectionProps.put("password", "kodilla_password");
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kodilla_course?serverTimezone=Europe/Warsaw" +
                        "&useSSL=False",
                connectionProps);
    }
    public static DbManager getInstance ()throws SQLException {
        if (dbManagerInstance == null) {
            dbManagerInstance = new DbManager();
        }
        return dbManagerInstance;
    }

    public java.sql.Connection getConnection() {
        return conn;
    }
}

