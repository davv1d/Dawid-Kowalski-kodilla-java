package com.kodilla.rps.logic.constant;

public class GameRoundResult extends GameResult {
    private static final String PLAYER_WON_THIS_ROUND = "Player won this round";
    private static final String COMPUTER_WON_THIS_ROUND = "Computer won this round";
    private static final String DRAW_IN_ROUND = "Draw this time";

    private GameRoundResult(String value) {
        super(value);
    }

    public static GameRoundResult playerWonThisRound() {
        return new GameRoundResult(PLAYER_WON_THIS_ROUND);
    }

    public static GameRoundResult computerWonThisRound() {
        return new GameRoundResult(COMPUTER_WON_THIS_ROUND);
    }

    public static GameRoundResult drawInRound() {
        return new GameRoundResult(DRAW_IN_ROUND);
    }

}
