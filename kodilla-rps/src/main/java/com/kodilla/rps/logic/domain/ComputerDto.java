package com.kodilla.rps.logic.domain;

import com.kodilla.rps.logic.GameStats;
import com.kodilla.rps.logic.symbol.Symbol;
import com.kodilla.rps.logic.symbol.SymbolName;

public class ComputerDto {
    private final Symbol playerSymbol;
    private final GameStats gameStats;
    private final SymbolName computerSymbolName;

    public ComputerDto(Symbol playerSymbol, GameStats gameStats, SymbolName computerSymbolName) {
        this.playerSymbol = playerSymbol;
        this.gameStats = gameStats;
        this.computerSymbolName = computerSymbolName;
    }

    public Symbol getPlayerSymbol() {
        return playerSymbol;
    }

    public GameStats getGameStats() {
        return gameStats;
    }

    public SymbolName getComputerSymbolName() {
        return computerSymbolName;
    }
}
