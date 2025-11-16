package org.example;

import java.sql.*;

public class MemoryDAO {

    public MemoryDAO() {
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS memory(
                    content TEXT PRIMARY KEY,
                    impact INTEGER,
                    recurrence INTEGER
                )
            """);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(Memory m) {
        String sql = "INSERT INTO memory(content, impact, recurrence) VALUES(?,?,?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, m.getContent());
            ps.setInt(2, m.getImpact());
            ps.setInt(3, m.getRecurrence());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir memory: " + e.getMessage());
        }
    }

    public void read() {
        String sql = "SELECT * FROM memory";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        "Memory → " + rs.getString("content") +
                                " | impact: " + rs.getInt("impact") +
                                " | recurrence: " + rs.getInt("recurrence")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao ler memory: " + e.getMessage());
        }
    }

    public void update(String content, int newImpact, int newRecurrence) {
        String sql = "UPDATE memory SET impact=?, recurrence=? WHERE content=?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, newImpact);
            ps.setInt(2, newRecurrence);
            ps.setString(3, content);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar memory: " + e.getMessage());
        }
    }

    public void delete(String content) {
        String sql = "DELETE FROM memory WHERE content=?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, content);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao deletar memory: " + e.getMessage());
        }
    }
}