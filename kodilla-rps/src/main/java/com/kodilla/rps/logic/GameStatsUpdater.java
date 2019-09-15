package com.kodilla.rps.logic;

import com.kodilla.rps.logic.constant.ErrorInTheGame;
import com.kodilla.rps.logic.constant.GameResult;
import com.kodilla.rps.logic.constant.GameRoundResult;
import com.kodilla.rps.logic.domain.GameLogicDto;
import com.kodilla.rps.logic.function.Result;

public class GameStatsUpdater {

    public Result<GameLogicDto> updateGameStatsAfterRound(GameLogicDto gameLogicDto) {
        int playerPoint = gameLogicDto.getGameStats().getPlayerPoints();
        int computerPoint = gameLogicDto.getGameStats().getComputerPoints();
        GameResult gameResult = gameLogicDto.getGameResult();
        if (!GameRoundResult.drawInRound().equals(gameResult)) {
            if (GameRoundResult.playerWonThisRound().equals(gameResult)) {
                playerPoint = gameLogicDto.getGameStats().getPlayerPoints() + 1;
            } else if (GameRoundResult.computerWonThisRound().equals(gameResult)) {
                computerPoint = gameLogicDto.getGameStats().getComputerPoints() + 1;
            } else {
                return Result.failure(GameStatsUpdater.class + " " + ErrorInTheGame.errorNotCorrectGameResult().getValue());
            }
        }
        int numberOfAvailableRounds = gameLogicDto.getGameStats().getNumberOfAvailableRounds() - 1;
        GameStats updatedGameStats = new GameStats(playerPoint, computerPoint, numberOfAvailableRounds);
        GameLogicDto result = new GameLogicDto(updatedGameStats, gameLogicDto.getPlayerSymbolName(), gameLogicDto.getComputerSymbolName(), gameLogicDto.getGameResult());
        return Result.success(result);
    }
}
