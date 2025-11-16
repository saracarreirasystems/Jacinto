package org.example;

import java.sql.*;

public class EmotionDAO {

    public EmotionDAO() {
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS emotion(
                    type TEXT PRIMARY KEY,
                    intensity INTEGER,
                    duration INTEGER
                )
            """);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(Emotion e) {
        String sql = "INSERT INTO emotion(type, intensity, duration) VALUES(?,?,?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getType());
            ps.setInt(2, e.getIntensity());
            ps.setInt(3, e.getDuration());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao inserir emotion: " + ex.getMessage());
        }
    }

    public void read() {
        String sql = "SELECT * FROM emotion";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        "Emotion → " + rs.getString("type") +
                                " | intensity: " + rs.getInt("intensity") +
                                " | duration: " + rs.getInt("duration")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao ler emotion: " + e.getMessage());
        }
    }

    public void update(String type, int newIntensity, int newDuration) {
        String sql = "UPDATE emotion SET intensity=?, duration=? WHERE type=?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, newIntensity);
            ps.setInt(2, newDuration);
            ps.setString(3, type);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar emotion: " + e.getMessage());
        }
    }

    public void delete(String type) {
        String sql = "DELETE FROM emotion WHERE type=?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, type);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao deletar emotion: " + e.getMessage());
        }
    }
}