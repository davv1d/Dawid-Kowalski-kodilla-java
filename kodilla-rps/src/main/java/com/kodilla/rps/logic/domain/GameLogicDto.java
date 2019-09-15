package com.kodilla.rps.logic.domain;

import com.kodilla.rps.logic.GameStats;
import com.kodilla.rps.logic.constant.GameResult;
import com.kodilla.rps.logic.symbol.SymbolName;

public class GameLogicDto {
    private final GameStats gameStats;
    private final SymbolName playerSymbolName;
    private final SymbolName computerSymbolName;
    private final GameResult gameResult;

    public GameLogicDto(GameStats gameStats, SymbolName playerSymbolName, SymbolName computerSymbolName, GameResult gameResult) {
        this.gameStats = gameStats;
        this.playerSymbolName = playerSymbolName;
        this.computerSymbolName = computerSymbolName;
        this.gameResult = gameResult;
    }

    public GameStats getGameStats() {
        return gameStats;
    }

    public SymbolName getPlayerSymbolName() {
        return playerSymbolName;
    }

    public SymbolName getComputerSymbolName() {
        return computerSymbolName;
    }

    public GameResult getGameResult() {
        return gameResult;
    }
}
