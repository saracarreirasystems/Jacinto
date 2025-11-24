package org.example.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClearDatabase {

    public static void clearAll() {
        try (Connection conn = Database.getConnection()) {

            String[] tables = {"Person", "Memory", "Emotion"};

            for (String table : tables) {
                String sql = "DELETE FROM " + table;
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}