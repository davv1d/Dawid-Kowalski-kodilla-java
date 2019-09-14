package com.kodilla.rps.domain;

public class ModelDto {
    private final GamePointStats gamePointStats;
    private final String playerSelection;
    private final String computerSelection;
    private final String gameStats;

    public ModelDto(GamePointStats gamePointStats, String playerSelection, String computerSelection, String gameStats) {
        this.gamePointStats = gamePointStats;
        this.playerSelection = playerSelection;
        this.computerSelection = computerSelection;
        this.gameStats = gameStats;
    }

    public GamePointStats getGamePointStats() {
        return gamePointStats;
    }

    public String getPlayerSelection() {
        return playerSelection;
    }

    public String getComputerSelection() {
        return computerSelection;
    }

    public String getGameStats() {
        return gameStats;
    }
}
