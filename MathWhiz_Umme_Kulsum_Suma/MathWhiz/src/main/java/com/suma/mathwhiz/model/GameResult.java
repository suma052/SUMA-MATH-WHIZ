package com.suma.mathwhiz.model;

public class GameResult {
    private final String playerName;
    private final int score;
    public GameResult(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }
    public String getPlayerName() { return playerName; }
    public int getScore() { return score; }
}
