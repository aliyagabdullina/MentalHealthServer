package DataBases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MeditationTable {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/meditations";
    private static final String USER = "aliya";
    private static final String PASSWORD = "1901";
    private static Connection conn;

    public static void createMeditationTable() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        String sql = "CREATE TABLE IF NOT EXISTS meditations (" +
                "id SERIAL PRIMARY KEY," +
                "url VARCHAR(255) NOT NULL," +
                "duration INT NOT NULL," +
                "workout_type VARCHAR(50) NOT NULL," +
                "difficulty VARCHAR(50) NOT NULL" +
                ")";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    public static void insertMeditations(int id, String url, int duration, String workout_type, String difficulty) throws SQLException {
        String sql = "INSERT INTO meditations (id, url, duration, workout_type, difficulty) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, url);
            stmt.setInt(3, duration);
            stmt.setString(4, workout_type);
            stmt.setString(5, difficulty);
            stmt.executeUpdate();
        }
    }
}
