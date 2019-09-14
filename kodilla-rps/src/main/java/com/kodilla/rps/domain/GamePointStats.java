package com.kodilla.rps.domain;

public class GamePointStats {
    private int playerPoints = 0;
    private int computerPoints = 0;
    private int numberOfRounds;

    public GamePointStats(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public GamePointStats(int playerPoints, int computerPoints, int numberOfRounds) {
        this.playerPoints = playerPoints;
        this.computerPoints = computerPoints;
        this.numberOfRounds = numberOfRounds;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public int getComputerPoints() {
        return computerPoints;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }
}
