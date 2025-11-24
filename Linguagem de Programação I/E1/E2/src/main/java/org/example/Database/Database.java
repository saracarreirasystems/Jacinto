package org.example.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final String URL = "jdbc:sqlite:E2.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // Cria tabelas se não existirem
    public static void initialize() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            String personTable = "CREATE TABLE IF NOT EXISTS Person (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "appearance TEXT," +
                    "mood TEXT)";
            stmt.execute(personTable);

            String memoryTable = "CREATE TABLE IF NOT EXISTS Memory (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "content TEXT," +
                    "impact INTEGER," +
                    "recurrence INTEGER)";
            stmt.execute(memoryTable);

            String emotionTable = "CREATE TABLE IF NOT EXISTS Emotion (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "type TEXT," +
                    "intensity INTEGER," +
                    "duration INTEGER)";
            stmt.execute(emotionTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}