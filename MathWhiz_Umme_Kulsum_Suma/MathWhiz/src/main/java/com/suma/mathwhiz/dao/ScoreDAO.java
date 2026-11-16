package com.suma.mathwhiz.dao;

import com.suma.mathwhiz.model.GameResult;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreDAO {
    public void saveScore(String playerName, int score, String difficulty) throws SQLException {
        String sql = "INSERT INTO game_scores (player_name, score, difficulty) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, playerName);
            ps.setInt(2, score);
            ps.setString(3, difficulty);
            ps.executeUpdate();
        }
    }

    public List<String[]> getTop10() throws SQLException {
        List<String[]> rows = new ArrayList<>();
        String sql = "SELECT player_name, score, difficulty, played_at " +
                     "FROM game_scores ORDER BY score DESC, played_at ASC LIMIT 10";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                rows.add(new String[] {
                    rs.getString("player_name"),
                    String.valueOf(rs.getInt("score")),
                    rs.getString("difficulty"),
                    rs.getTimestamp("played_at").toString()
                });
            }
        }
        return rows;
    }
}
