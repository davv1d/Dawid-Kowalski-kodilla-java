package com.kodilla.rps.judge;

import com.kodilla.rps.domain.GameStats;
import com.kodilla.rps.elements.Element;
import com.kodilla.rps.elements.ElementName;

public class Judge {
    public static final String PLAYER_WON_THIS_ROUND = "Player won this round";
    public static final String COMPUTER_WON_THIS_ROUND = "Computer won this round";
    public static final String DRAW_IN_ROUND = "Draw this time";
    public static final String ERROR_IN_DEPENDENCIES = "ERROR in dependencies among elements";
    private static final String PLAYER_WON_GAME = "Player won game";
    private static final String COMPUTER_WON_GAME = "Computer won game";
    private static final String DRAW_IN_GAME = "Draw in this game";

    public String checkWhoWinRound(Element playerElement, ElementName computerElementName) {
        if (playerElement.getElementsWhichDefeatMe().contains(computerElementName)) {
            return COMPUTER_WON_THIS_ROUND;
        } else if (playerElement.getElementsThatIOvercomes().contains(computerElementName)) {
            return PLAYER_WON_THIS_ROUND;
        } else if (playerElement.getName().equals(computerElementName)) {
            return DRAW_IN_ROUND;
        } else {
            return ERROR_IN_DEPENDENCIES;
        }
    }

    public String checkIfSomeoneHasWonTheGame(GameStats gameStats, String roundResult) {
        if (gameStats.getNumberOfAvailableRounds() == 0) {
            if (gameStats.getPlayerPoints() > gameStats.getComputerPoints()) {
                return PLAYER_WON_GAME;
            } else if (gameStats.getComputerPoints() > gameStats.getPlayerPoints()) {
                return COMPUTER_WON_GAME;
            } else {
                return DRAW_IN_GAME;
            }
        } else {
            return roundResult;
        }
    }
}
