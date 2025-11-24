package org.example.DAO;

import org.example.Database.Database;
import org.example.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public void insert(Person person) {
        String sql = "INSERT INTO Person(name, appearance, mood) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, person.getName());
            pstmt.setString(2, person.getAppearance());
            pstmt.setString(3, person.getMood());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> getAll() {
        List<Person> list = new ArrayList<>();
        String sql = "SELECT name, appearance, mood FROM Person";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Person(
                        rs.getString("name"),
                        rs.getString("appearance"),
                        rs.getString("mood")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}