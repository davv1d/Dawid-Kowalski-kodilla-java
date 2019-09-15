package com.kodilla.rps.domain;

import com.kodilla.rps.elements.Element;

public class FactoryElementDto {
    private final Element playerElement;
    private final GameStats gameStats;

    public FactoryElementDto(Element playerElement, GameStats gameStats) {
        this.playerElement = playerElement;
        this.gameStats = gameStats;
    }

    public Element getPlayerElement() {
        return playerElement;
    }

    public GameStats getGameStats() {
        return gameStats;
    }
}
