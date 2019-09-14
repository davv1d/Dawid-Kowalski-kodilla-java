package com.kodilla.rps.model;

import com.kodilla.rps.domain.GamePointStats;
import com.kodilla.rps.computer.Computer;
import com.kodilla.rps.domain.ModelDto;
import com.kodilla.rps.elements.Element;
import com.kodilla.rps.elements.ElementName;
import com.kodilla.rps.elements.ElementsFactory;
import com.kodilla.rps.judge.Judge;

public class Model {
    private Judge judge = new Judge();

    public ModelDto play(String playerMove, GamePointStats gamePointStats) {
        Element playerElement = ElementsFactory.creatingAnElementBasedOnTheGivenDate(playerMove);
        if (!playerElement.getName().equals(ElementName.ERROR)) {
                return makeOneRoundGame(gamePointStats, playerElement);
        } else {
            return new ModelDto(gamePointStats, playerElement.getName().toString(), "non", "non");
        }
    }

    private ModelDto makeOneRoundGame(GamePointStats gamePointStats, Element playerElement) {
        ElementName computerElementName = new Computer().getElementSelectedByComputer(playerElement);
        String result = judge.checkWhoWinRound(playerElement, computerElementName);
        GamePointStats updatedGamePoints = updateGamePointStats(result, gamePointStats);
        result = judge.checkIfSomeoneHasWonTheGame(updatedGamePoints, result);
        return new ModelDto(updatedGamePoints, playerElement.getName().toString(), computerElementName.toString(), result);
    }

    private GamePointStats updateGamePointStats(String result, GamePointStats gamePointStats) {
        int playerPoint = gamePointStats.getPlayerPoints();
        int computerPoint = gamePointStats.getComputerPoints();
        switch (result) {
            case Judge.PLAYER:
                playerPoint = gamePointStats.getPlayerPoints() + 1;
                break;
            case Judge.COMPUTER:
                computerPoint = gamePointStats.getComputerPoints() + 1;
                break;
            case Judge.ERROR:
                System.out.println(result);
                break;
        }
        return new GamePointStats(playerPoint, computerPoint, gamePointStats.getNumberOfRounds() - 1);
    }

}
