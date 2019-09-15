package com.kodilla.rps.logic;

import com.kodilla.rps.logic.computer.Computer;
import com.kodilla.rps.logic.domain.GameLogicDto;
import com.kodilla.rps.logic.function.Result;
import com.kodilla.rps.logic.judge.Judge;
import com.kodilla.rps.logic.symbol.SymbolsFactory;

public class GameLogic {
    private Judge judge = new Judge();
    private GameStatsUpdater updater = new GameStatsUpdater();
    private Computer computer = new Computer();

    public Result<GameLogicDto> startGame(String symbolChosenByThePlayer, GameStats gameStats) {
        return SymbolsFactory
                .makeElement(symbolChosenByThePlayer, gameStats)
                .flatMap(computer::selectTheComputerSymbol)
                .flatMap(judge::checkWhoWinRound)
                .flatMap(updater::updateGameStatsAfterRound)
                .map(judge::checkIfSomeoneHasWonTheGame);
    }
}
