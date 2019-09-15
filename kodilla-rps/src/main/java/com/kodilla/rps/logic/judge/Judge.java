package com.kodilla.rps.logic.judge;

import com.kodilla.rps.logic.constant.ErrorInTheGame;
import com.kodilla.rps.logic.constant.GameResult;
import com.kodilla.rps.logic.constant.GameRoundResult;
import com.kodilla.rps.logic.domain.ComputerDto;
import com.kodilla.rps.logic.domain.GameLogicDto;
import com.kodilla.rps.logic.function.Result;

public class Judge {

    public Result<GameLogicDto> checkWhoWinRound(ComputerDto computerDto) {
        GameResult resultGame;
        if (checkIfTheComputerWonTheRound(computerDto)) {
            resultGame = GameRoundResult.computerWonThisRound();
        } else if (checkIfThePlayerWonTheRound(computerDto)) {
            resultGame = GameRoundResult.playerWonThisRound();
        } else if (checkIfThereIsDrawInRound(computerDto)) {
            resultGame = GameRoundResult.drawInRound();
        } else {
            return Result.failure(Judge.class + " " + ErrorInTheGame.errorInDependenciesAmongSymbols().getValue());
        }
        return Result.success(new GameLogicDto(computerDto.getGameStats(), computerDto.getPlayerSymbol().getName(), computerDto.getComputerSymbolName(), resultGame));
    }

    private boolean checkIfThereIsDrawInRound(ComputerDto computerDto) {
        return computerDto.getPlayerSymbol().getName().equals(computerDto.getComputerSymbolName());
    }

    private boolean checkIfThePlayerWonTheRound(ComputerDto computerDto) {
        return computerDto.getPlayerSymbol().getSymbolsNamesThatIOvercomes().contains(computerDto.getComputerSymbolName());
    }

    private boolean checkIfTheComputerWonTheRound(ComputerDto computerDto) {
        return computerDto.getPlayerSymbol().getSymbolsNamesWhichDefeatMe().contains(computerDto.getComputerSymbolName());
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
        return new GameLogicDto(gameLogicDto.getGameStats(), gameLogicDto.getPlayerSymbolName(), gameLogicDto.getComputerSymbolName(), resultGame);
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
