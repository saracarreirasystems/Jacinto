package org.example;

import java.sql.*;

public class PersonDAO {

    public PersonDAO() {
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS person(
                    name TEXT PRIMARY KEY,
                    appearance TEXT,
                    mood TEXT
                )
            """);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(Person p) {
        String sql = "INSERT INTO person(name, appearance, mood) VALUES(?,?,?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setString(2, p.getAppearance());
            ps.setString(3, p.getMood());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir pessoa: " + e.getMessage());
        }
    }

    public void read() {
        String sql = "SELECT * FROM person";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        "Person → " + rs.getString("name") +
                                " | appearance: " + rs.getString("appearance") +
                                " | mood: " + rs.getString("mood")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao ler pessoas: " + e.getMessage());
        }
    }

    public void update(String name, String newAppearance, String newMood) {
        String sql = "UPDATE person SET appearance=?, mood=? WHERE name=?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newAppearance);
            ps.setString(2, newMood);
            ps.setString(3, name);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pessoa: " + e.getMessage());
        }
    }

    public void delete(String name) {
        String sql = "DELETE FROM person WHERE name=?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao deletar pessoa: " + e.getMessage());
        }
    }
}