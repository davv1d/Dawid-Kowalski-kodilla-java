package com.kodilla.rps.model;

import com.kodilla.rps.domain.GameLogicDto;
import com.kodilla.rps.domain.GameStats;
import com.kodilla.rps.functional.Result;
import com.kodilla.rps.constant.ErrorInGame;
import com.kodilla.rps.constant.GameResult;
import com.kodilla.rps.constant.GameRoundResult;

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
                return Result.failure(ErrorInGame.errorNotCorrectGameResult().getValue());
            }
        }
        int numberOfAvailableRounds = gameLogicDto.getGameStats().getNumberOfAvailableRounds() - 1;
        GameStats updatedGameStats = new GameStats(playerPoint, computerPoint, numberOfAvailableRounds);
        GameLogicDto result = new GameLogicDto(updatedGameStats, gameLogicDto.getPlayerMovement(), gameLogicDto.getComputerMovement(), gameLogicDto.getGameResult());
        return Result.success(result);
    }
}
