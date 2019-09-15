package com.kodilla.rps.model;

import com.kodilla.rps.computer.Computer;
import com.kodilla.rps.domain.GameLogicDto;
import com.kodilla.rps.domain.GameStats;
import com.kodilla.rps.elements.ElementsFactory;
import com.kodilla.rps.functional.Result;
import com.kodilla.rps.judge.Judge;

public class GameLogic {
    private Judge judge = new Judge();
    private GameStatsUpdater updater = new GameStatsUpdater();
    private Computer computer = new Computer();

    public Result<GameLogicDto> startGame(String playerMove, GameStats gameStats) {
        return ElementsFactory
                .makeElement(playerMove, gameStats)
                .flatMap(computer::getElementSelectedByComputer)
                .flatMap(judge::checkWhoWinRound)
                .flatMap(updater::updateGameStatsAfterRound)
                .map(judge::checkIfSomeoneHasWonTheGame);
    }
}
