package com.kodilla.rps.model;

import com.kodilla.rps.computer.Computer;
import com.kodilla.rps.domain.ComputerDto;
import com.kodilla.rps.domain.FactoryElementDto;
import com.kodilla.rps.domain.GameLogicDto;
import com.kodilla.rps.domain.GameStats;
import com.kodilla.rps.elements.ElementsFactory;
import com.kodilla.rps.functional.Result;
import com.kodilla.rps.judge.Judge;

public class GameLogic {
    private Judge judge = new Judge();

    public Result<GameLogicDto> startGame(String playerMove, GameStats gameStats) {
        Result<FactoryElementDto> factoryElementDtoResult = ElementsFactory.makeElement(playerMove, gameStats);
        return factoryElementDtoResult.flatMap(this::makeOneRoundGame);
//        if (!playerElement.getName().equals(ElementName.ERROR_NOT_FOUND_NAME)) {
//            return makeOneRoundGame(gameStats, playerElement);
//        } else {
//            return new GameLogicDto(gameStats, playerElement.getName().toString(), "non", "non");
//        }
    }

    private Result<GameLogicDto> makeOneRoundGame(FactoryElementDto factoryElementDto) {
        Result<ComputerDto> computerDto = new Computer().getElementSelectedByComputer(factoryElementDto);
        Result<GameLogicDto> gameLogicDtoResult = computerDto.flatMap(judge::checkWhoWinRound).map(GameStatsUpdater::updateGameStats);
        return gameLogicDtoResult.map(judge::checkIfSomeoneHasWonTheGame);
        //        gameResult = judge.checkIfSomeoneHasWonTheGame(updatedGameStats, gameResult);
//        return new GameLogicDto(updatedGameStats, factoryElementDto.getPlayerElement().getName().toString(), computerElementName.toString(), gameResult);
    }
}
