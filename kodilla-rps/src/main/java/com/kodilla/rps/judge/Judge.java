package com.kodilla.rps.judge;

import com.kodilla.rps.domain.GamePointStats;
import com.kodilla.rps.elements.Element;
import com.kodilla.rps.elements.ElementName;

public class Judge {
    public static final String PLAYER = "Player won this round";
    public static final String COMPUTER = "Computer won this round";
    public static final String DRAW = "Draw this time";
    public static final String ERROR = "ERROR in dependencies among elements";

    public String checkWhoWinRound(Element playerElement, ElementName computerElementName) {
        if (playerElement.getElementsWhichDefeatMe().contains(computerElementName)) {
            return COMPUTER;
        } else if (playerElement.getElementsThatIOvercomes().contains(computerElementName)) {
            return PLAYER;
        } else if (playerElement.getName().equals(computerElementName)) {
            return DRAW;
        } else {
            return ERROR;
        }
    }

    public String checkIfSomeoneHasWonTheGame(GamePointStats gamePointStats, String roundResult) {
        if (gamePointStats.getNumberOfRounds() == 0) {
            if (gamePointStats.getPlayerPoints() > gamePointStats.getComputerPoints()) {
                return "Player won game";
            } else if (gamePointStats.getComputerPoints() > gamePointStats.getPlayerPoints()) {
                return "Computer won game";
            } else {
                return "Draw in this game";
            }
        } else {
            return roundResult;
        }
    }
}
