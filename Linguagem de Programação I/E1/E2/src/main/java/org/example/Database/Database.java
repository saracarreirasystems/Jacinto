package org.example.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    private static final String URL = "jdbc:sqlite:E2.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver SQLite não encontrado. Adicione sqlite-jdbc no classpath.", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        try (Statement st = conn.createStatement()) {
            st.execute("PRAGMA foreign_keys = ON");
        }
        return conn;
    }


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


    public static int insertPerson(String name, String appearance, String mood) {
        String sql = "INSERT INTO Person (name, appearance, mood) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, name);
            ps.setString(2, appearance);
            ps.setString(3, mood);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) return rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static List<Map<String, Object>> selectAllPersons() {
        String sql = "SELECT id, name, appearance, mood FROM Person";
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Map<String, Object> row = new HashMap<String, Object>();
                row.put("id", rs.getInt("id"));
                row.put("name", rs.getString("name"));
                row.put("appearance", rs.getString("appearance"));
                row.put("mood", rs.getString("mood"));
                result.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Map<String, Object> selectPersonById(int id) {
        String sql = "SELECT id, name, appearance, mood FROM Person WHERE id = ?";
        Map<String, Object> row = null;

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    row = new HashMap<String, Object>();
                    row.put("id", rs.getInt("id"));
                    row.put("name", rs.getString("name"));
                    row.put("appearance", rs.getString("appearance"));
                    row.put("mood", rs.getString("mood"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public static boolean updatePerson(int id, String name, String appearance, String mood) {
        String sql = "UPDATE Person SET name = ?, appearance = ?, mood = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, appearance);
            ps.setString(3, mood);
            ps.setInt(4, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deletePerson(int id) {
        String sql = "DELETE FROM Person WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static int insertMemory(String content, int impact, int recurrence) {
        String sql = "INSERT INTO Memory (content, impact, recurrence) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, content);
            ps.setInt(2, impact);
            ps.setInt(3, recurrence);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) return rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static List<Map<String, Object>> selectAllMemories() {
        String sql = "SELECT id, content, impact, recurrence FROM Memory";
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Map<String, Object> row = new HashMap<String, Object>();
                row.put("id", rs.getInt("id"));
                row.put("content", rs.getString("content"));
                row.put("impact", rs.getInt("impact"));
                row.put("recurrence", rs.getInt("recurrence"));
                result.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Map<String, Object> selectMemoryById(int id) {
        String sql = "SELECT id, content, impact, recurrence FROM Memory WHERE id = ?";
        Map<String, Object> row = null;

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    row = new HashMap<String, Object>();
                    row.put("id", rs.getInt("id"));
                    row.put("content", rs.getString("content"));
                    row.put("impact", rs.getInt("impact"));
                    row.put("recurrence", rs.getInt("recurrence"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public static boolean updateMemory(int id, String content, int impact, int recurrence) {
        String sql = "UPDATE Memory SET content = ?, impact = ?, recurrence = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, content);
            ps.setInt(2, impact);
            ps.setInt(3, recurrence);
            ps.setInt(4, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteMemory(int id) {
        String sql = "DELETE FROM Memory WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static int insertEmotion(String type, int intensity, int duration) {
        String sql = "INSERT INTO Emotion (type, intensity, duration) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, type);
            ps.setInt(2, intensity);
            ps.setInt(3, duration);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) return rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static List<Map<String, Object>> selectAllEmotions() {
        String sql = "SELECT id, type, intensity, duration FROM Emotion";
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Map<String, Object> row = new HashMap<String, Object>();
                row.put("id", rs.getInt("id"));
                row.put("type", rs.getString("type"));
                row.put("intensity", rs.getInt("intensity"));
                row.put("duration", rs.getInt("duration"));
                result.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Map<String, Object> selectEmotionById(int id) {
        String sql = "SELECT id, type, intensity, duration FROM Emotion WHERE id = ?";
        Map<String, Object> row = null;

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    row = new HashMap<String, Object>();
                    row.put("id", rs.getInt("id"));
                    row.put("type", rs.getString("type"));
                    row.put("intensity", rs.getInt("intensity"));
                    row.put("duration", rs.getInt("duration"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public static boolean updateEmotion(int id, String type, int intensity, int duration) {
        String sql = "UPDATE Emotion SET type = ?, intensity = ?, duration = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, type);
            ps.setInt(2, intensity);
            ps.setInt(3, duration);
            ps.setInt(4, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteEmotion(int id) {
        String sql = "DELETE FROM Emotion WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
