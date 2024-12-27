package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * This class manages the database connection and execution of SQL queries.
 */
public class DataBaseConnection {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/java_db";
    private static final String USER = "root";
    private static final String PASSWORD = "88888888";

    /**
     * Establishes a connection to the database.
     *
     * @return a Connection object to interact with the database.
     * @throws SQLException if a database access error occurs.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Executes the given SQL query and prints the result of the operation.
     *
     * @param query the SQL query to execute.
     */
    public static void executeQuery(String query) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            int rowsAffected = statement.executeUpdate(query);

            if (rowsAffected > 0) {
                System.out.println("Query executed successfully. Rows affected: " + rowsAffected);
            } else {
                System.out.println("No rows affected.");
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}
