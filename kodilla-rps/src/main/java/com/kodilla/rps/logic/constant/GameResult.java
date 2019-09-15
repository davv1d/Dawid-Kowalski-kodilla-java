package com.kodilla.rps.logic.constant;

public class GameResult {
    private static final String PLAYER_WON_GAME = "Player won game";
    private static final String COMPUTER_WON_GAME = "Computer won game";
    private static final String DRAW_IN_GAME = "Draw in this game";
    private final String value;

    public String getValue() {
        return value;
    }

    GameResult(String value) {
        this.value = value;
    }

    public static GameResult playerWonGame() {
        return new GameResult(PLAYER_WON_GAME);
    }

    public static GameResult computerWonGame() {
        return new GameResult(COMPUTER_WON_GAME);
    }

    public static GameResult drawInGame() {
        return new GameResult(DRAW_IN_GAME);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameResult that = (GameResult) o;

        return getValue() != null ? getValue().equals(that.getValue()) : that.getValue() == null;

    }

    @Override
    public int hashCode() {
        return getValue() != null ? getValue().hashCode() : 0;
    }
}
