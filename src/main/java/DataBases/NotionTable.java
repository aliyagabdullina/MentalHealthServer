package DataBases;

import models.Notion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NotionTable {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/notions";
    private static final String USER = "aliya";
    private static final String PASSWORD = "1901";
    private static Connection conn;
    public static void createNotionTable() throws SQLException {

        conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        String sql = "CREATE TABLE IF NOT EXISTS notions (" +
                "id SERIAL PRIMARY KEY," +
                "image VARCHAR(50) NOT NULL," +
                "date VARCHAR(50) NOT NULL," +
                "note_text VARCHAR(255)," +
                "activity_texts TEXT[]" +
                ")";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        }
    }


    public static void insertNotion(Notion notion) throws SQLException {

        String sql = "INSERT INTO notions (image, date, note_text, activity_texts) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, notion.getEmoji());
            stmt.setString(2, notion.getDate());
            stmt.setString(3, notion.getNoteText());
            stmt.setArray(4, conn.createArrayOf("text", notion.getActivityTextsList().toArray()));
            stmt.executeUpdate();
        }
    }

}
