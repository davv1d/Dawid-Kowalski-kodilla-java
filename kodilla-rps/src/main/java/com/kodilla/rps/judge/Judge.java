package com.kodilla.rps.judge;

import com.kodilla.rps.elements.Element;
import com.kodilla.rps.elements.ElementName;

public class Judge {
    public static final String PLAYER = "Player";
    public static final String COMPUTER = "Computer";
    public static final String DRAW = "DRAW";
    public static final String ERROR = "ERROR in dependencies among elements";

    public String checkWhoWin(Element playerElement, ElementName computerElementName) {
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
}
