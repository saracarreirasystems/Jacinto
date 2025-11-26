package org.example.DAO;

import org.example.Database.Database;
import org.example.Memory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemoryDAO {

    public void insert(Memory memory) {
        String sql = "INSERT INTO Memory(content, impact, recurrence) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, memory.getContent());
            pstmt.setInt(2, memory.getImpact());
            pstmt.setInt(3, memory.getRecurrence());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Memory> getAll() {
        List<Memory> list = new ArrayList<>();
        String sql = "SELECT content, impact, recurrence FROM Memory";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Memory(
                        rs.getString("content"),
                        rs.getInt("impact"),
                        rs.getInt("recurrence")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}