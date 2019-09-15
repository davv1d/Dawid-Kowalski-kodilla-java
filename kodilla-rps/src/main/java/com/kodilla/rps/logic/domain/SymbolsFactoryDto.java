package com.kodilla.rps.logic.domain;

import com.kodilla.rps.logic.GameStats;
import com.kodilla.rps.logic.symbol.Symbol;

public class SymbolsFactoryDto {
    private final Symbol playerSymbol;
    private final GameStats gameStats;

    public SymbolsFactoryDto(Symbol playerSymbol, GameStats gameStats) {
        this.playerSymbol = playerSymbol;
        this.gameStats = gameStats;
    }

    public Symbol getPlayerSymbol() {
        return playerSymbol;
    }

    public GameStats getGameStats() {
        return gameStats;
    }
}
