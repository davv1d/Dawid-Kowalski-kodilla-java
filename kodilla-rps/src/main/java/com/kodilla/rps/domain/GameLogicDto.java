package com.kodilla.rps.domain;

public class GameLogicDto {
    private final GameStats gameStats;
    private final String playerMovement;
    private final String computerMovement;
    private final String gameResult;

    public GameLogicDto(GameStats gameStats, String playerMovement, String computerMovement, String gameResult) {
        this.gameStats = gameStats;
        this.playerMovement = playerMovement;
        this.computerMovement = computerMovement;
        this.gameResult = gameResult;
    }

    public GameStats getGameStats() {
        return gameStats;
    }

    public String getPlayerMovement() {
        return playerMovement;
    }

    public String getComputerMovement() {
        return computerMovement;
    }

    public String getGameResult() {
        return gameResult;
    }
}
