package br.com.polizello.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5434/polizello", "postgres", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
