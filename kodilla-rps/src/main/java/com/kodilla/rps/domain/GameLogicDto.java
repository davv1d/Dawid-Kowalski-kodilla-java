package com.kodilla.rps.domain;

import com.kodilla.rps.elements.ElementName;
import com.kodilla.rps.constant.GameResult;

public class GameLogicDto {
    private final GameStats gameStats;
    private final ElementName playerMovement;
    private final ElementName computerMovement;
    private final GameResult gameResult;

    public GameLogicDto(GameStats gameStats, ElementName playerMovement, ElementName computerMovement, GameResult gameResult) {
        this.gameStats = gameStats;
        this.playerMovement = playerMovement;
        this.computerMovement = computerMovement;
        this.gameResult = gameResult;
    }

    public GameStats getGameStats() {
        return gameStats;
    }

    public ElementName getPlayerMovement() {
        return playerMovement;
    }

    public ElementName getComputerMovement() {
        return computerMovement;
    }

    public GameResult getGameResult() {
        return gameResult;
    }
}
