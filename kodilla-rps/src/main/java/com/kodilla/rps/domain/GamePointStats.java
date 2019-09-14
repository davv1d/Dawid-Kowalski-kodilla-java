package com.kodilla.rps;

public class GamePointStats {
    private int playerPoints = 0;
    private int computerPoints = 0;
    private int numberOfRounds = 0;

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

    //    public static void play(String keyPushFromPlayer) {
//        Element playerElement;
//        try {
//            playerElement = ElementsFactory.creatingAnElementBasedOnTheGivenDate(keyPushFromPlayer);
//            ElementName computerElement = new Computer().getElementSelectedByComputer(playerElement);
//            String result = new Judge().checkWhoWinRound(playerElement, computerElement);
//        } catch (ElementCreateException e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
