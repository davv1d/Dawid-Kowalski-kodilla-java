package com.kodilla.rps.domain;

import com.kodilla.rps.elements.Element;
import com.kodilla.rps.elements.ElementName;

public class ComputerDto {
    private final Element playerElement;
    private final GameStats gameStats;
    private final ElementName computerElementName;

    public ComputerDto(Element playerElement, GameStats gameStats, ElementName computerElementName) {
        this.playerElement = playerElement;
        this.gameStats = gameStats;
        this.computerElementName = computerElementName;
    }

    public Element getPlayerElement() {
        return playerElement;
    }

    public GameStats getGameStats() {
        return gameStats;
    }

    public ElementName getComputerElementName() {
        return computerElementName;
    }
}
