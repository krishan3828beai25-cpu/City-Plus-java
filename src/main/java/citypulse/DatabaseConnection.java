package citypulse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:citypulse.db";

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initialize() {
        String[] sql = {
            "CREATE TABLE IF NOT EXISTS traffic (id INTEGER PRIMARY KEY, location TEXT, vehicles INTEGER, congestion TEXT)",
            "CREATE TABLE IF NOT EXISTS resources (id INTEGER PRIMARY KEY, type TEXT, location TEXT, amount REAL)",
            "CREATE TABLE IF NOT EXISTS requests (id INTEGER PRIMARY KEY, location TEXT, type TEXT, status TEXT)",
            "CREATE TABLE IF NOT EXISTS reports (id INTEGER PRIMARY KEY AUTOINCREMENT, summary TEXT, created_at TEXT)"
        };
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            for (String query : sql) statement.execute(query);
        } catch (SQLException e) {
            System.out.println("Database setup skipped: " + e.getMessage());
        }
    }
}
