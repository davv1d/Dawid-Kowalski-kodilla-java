package com.kodilla.rps.judge;

import com.kodilla.rps.domain.ComputerDto;
import com.kodilla.rps.domain.GameLogicDto;
import com.kodilla.rps.functional.Result;
import com.kodilla.rps.constant.ErrorInGame;
import com.kodilla.rps.constant.GameResult;
import com.kodilla.rps.constant.GameRoundResult;

public class Judge {

    public Result<GameLogicDto> checkWhoWinRound(ComputerDto computerDto) {
        GameResult resultGame;
        if (computerDto.getPlayerElement().getElementsWhichDefeatMe().contains(computerDto.getComputerElementName())) {
            resultGame = GameRoundResult.computerWonThisRound();
        } else if (computerDto.getPlayerElement().getElementsThatIOvercomes().contains(computerDto.getComputerElementName())) {
            resultGame = GameRoundResult.playerWonThisRound();
        } else if (computerDto.getPlayerElement().getName().equals(computerDto.getComputerElementName())) {
            resultGame = GameRoundResult.drawInRound();
        } else {
            return Result.failure(ErrorInGame.errorInDependenciesAmongElement().getValue());
        }
        return Result.success(new GameLogicDto(
                computerDto.getGameStats(),
                computerDto.getPlayerElement().getName(),
                computerDto.getComputerElementName(),
                resultGame));
    }

    public GameLogicDto checkIfSomeoneHasWonTheGame(GameLogicDto gameLogicDto) {
        GameResult resultGame = gameLogicDto.getGameResult();
        if (!checkIfThereAreAnyRoundsAvailable(gameLogicDto)) {
            if (checkIfThePlayerHasWon(gameLogicDto)) {
                resultGame = GameResult.playerWonGame();
            } else if (checkIfTheComputerHasWon(gameLogicDto)) {
                resultGame = GameResult.computerWonGame();
            } else {
                resultGame = GameResult.drawInGame();
            }
        }
        return new GameLogicDto(gameLogicDto.getGameStats(), gameLogicDto.getPlayerMovement(), gameLogicDto.getComputerMovement(), resultGame);
    }

    private boolean checkIfThereAreAnyRoundsAvailable(GameLogicDto gameLogicDto) {
        return gameLogicDto.getGameStats().getNumberOfAvailableRounds() > 0;
    }

    private boolean checkIfThePlayerHasWon(GameLogicDto gameLogicDto) {
        return gameLogicDto.getGameStats().getPlayerPoints() > gameLogicDto.getGameStats().getComputerPoints();
    }

    private boolean checkIfTheComputerHasWon(GameLogicDto gameLogicDto) {
        return gameLogicDto.getGameStats().getPlayerPoints() < gameLogicDto.getGameStats().getComputerPoints();
    }
}
