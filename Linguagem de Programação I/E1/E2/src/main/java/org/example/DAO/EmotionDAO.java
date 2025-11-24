package org.example.DAO;

import org.example.Database.Database;
import org.example.Emotion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmotionDAO {

    public void insert(Emotion emotion) {
        String sql = "INSERT INTO Emotion(type, intensity, duration) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, emotion.getType());
            pstmt.setInt(2, emotion.getIntensity());
            pstmt.setInt(3, emotion.getDuration());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Emotion> getAll() {
        List<Emotion> list = new ArrayList<>();
        String sql = "SELECT type, intensity, duration FROM Emotion";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Emotion(
                        rs.getString("type"),
                        rs.getInt("intensity"),
                        rs.getInt("duration")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}