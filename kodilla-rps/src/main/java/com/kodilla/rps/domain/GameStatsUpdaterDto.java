package com.kodilla.rps.domain;

public class GameStatsUpdaterDto {
    private final String gameResult;
    private final GameStats gameStats;

    public GameStatsUpdaterDto(String gameResult, GameStats gameStats) {
        this.gameResult = gameResult;
        this.gameStats = gameStats;
    }

    public String getGameResult() {
        return gameResult;
    }

    public GameStats getGameStats() {
        return gameStats;
    }
}
