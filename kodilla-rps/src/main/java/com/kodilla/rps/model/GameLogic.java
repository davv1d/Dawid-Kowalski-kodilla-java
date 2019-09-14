package com.kodilla.rps.model;

import com.kodilla.rps.domain.GameStats;
import com.kodilla.rps.computer.Computer;
import com.kodilla.rps.domain.GameLogicDto;
import com.kodilla.rps.elements.Element;
import com.kodilla.rps.elements.ElementName;
import com.kodilla.rps.elements.ElementsFactory;
import com.kodilla.rps.judge.Judge;

public class GameLogic {
    private Judge judge = new Judge();

    public GameLogicDto startGame(String playerMove, GameStats gameStats) {
        Element playerElement = ElementsFactory.makeElement(playerMove);
        if (!playerElement.getName().equals(ElementName.ERROR_NOT_FOUND_NAME)) {
            return makeOneRoundGame(gameStats, playerElement);
        } else {
            return new GameLogicDto(gameStats, playerElement.getName().toString(), "non", "non");
        }
    }

    private GameLogicDto makeOneRoundGame(GameStats gameStats, Element playerElement) {
        ElementName computerElementName = new Computer().getElementSelectedByComputer(playerElement);
        String gameResult = judge.checkWhoWinRound(playerElement, computerElementName);
        GameStats updatedGameStats = updateGameStats(gameResult, gameStats);
        gameResult = judge.checkIfSomeoneHasWonTheGame(updatedGameStats, gameResult);
        return new GameLogicDto(updatedGameStats, playerElement.getName().toString(), computerElementName.toString(), gameResult);
    }

    private GameStats updateGameStats(String result, GameStats gameStats) {
        int playerPoint = gameStats.getPlayerPoints();
        int computerPoint = gameStats.getComputerPoints();
        switch (result) {
            case Judge.PLAYER_WON_THIS_ROUND:
                playerPoint = gameStats.getPlayerPoints() + 1;
                break;
            case Judge.COMPUTER_WON_THIS_ROUND:
                computerPoint = gameStats.getComputerPoints() + 1;
                break;
            case Judge.ERROR_IN_DEPENDENCIES:
                System.out.println(result);
                break;
        }
        return new GameStats(playerPoint, computerPoint, gameStats.getNumberOfAvailableRounds() - 1);
    }

}
