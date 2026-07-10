package ir.maktabsharif.discount.util;

import ir.maktabsharif.discount.exception.DatabaseConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/cw17";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "2117";

    public static Connection getConnection() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            return connection;
        }
        catch (SQLException e) {
            throw new DatabaseConnectionException("Connection to Database Failed!");
        }
    }
}
