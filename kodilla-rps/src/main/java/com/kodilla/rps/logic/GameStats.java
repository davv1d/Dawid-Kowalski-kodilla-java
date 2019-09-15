package com.kodilla.rps.logic;

public class GameStats {
    private final int playerPoints;
    private final int computerPoints;
    private final int numberOfAvailableRounds;

    public GameStats(int playerPoints, int computerPoints, int numberOfAvailableRounds) {
        this.playerPoints = playerPoints;
        this.computerPoints = computerPoints;
        this.numberOfAvailableRounds = numberOfAvailableRounds;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public int getComputerPoints() {
        return computerPoints;
    }

    public int getNumberOfAvailableRounds() {
        return numberOfAvailableRounds;
    }
}
