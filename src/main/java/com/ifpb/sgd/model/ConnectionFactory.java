package com.ifpb.sgd.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static ConnectionFactory instance = new ConnectionFactory();
    public static final String URL = "jdbc:postgresql://localhost:5432/exerciciojwt";
    public static final String USER = "postgres";
    public static final String PASSWORD = "postgres";
    public static final String DRIVER_CLASS = "org.postgresql.Driver";

    private ConnectionFactory() {
        try { Class.forName(DRIVER_CLASS);
        }
        catch(ClassNotFoundException ex) {
            ex.getMessage();
        }
    }

    private Connection createConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch(SQLException ex) {
            ex.getMessage();
        }
        return conn;
    }
    public static Connection getConnection() {
        return instance.createConnection();
    }
}
