package com.kodilla.rps.domain;

import com.kodilla.rps.elements.Element;
import com.kodilla.rps.elements.ElementName;

public class JudgeDto {
    private final Element playerElement;
    private final ElementName computerElementName;
    private final GameStats gameStats;

    public JudgeDto(Element playerElement, ElementName computerElementName, GameStats gameStats) {
        this.playerElement = playerElement;
        this.computerElementName = computerElementName;
        this.gameStats = gameStats;
    }

    public Element getPlayerElement() {
        return playerElement;
    }

    public ElementName getComputerElementName() {
        return computerElementName;
    }

    public GameStats getGameStats() {
        return gameStats;
    }
}
