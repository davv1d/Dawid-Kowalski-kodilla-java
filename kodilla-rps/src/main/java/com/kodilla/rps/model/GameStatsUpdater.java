package com.kodilla.rps.model;

import com.kodilla.rps.domain.GameLogicDto;
import com.kodilla.rps.domain.GameStats;
import com.kodilla.rps.judge.Judge;

public class GameStatsUpdater {

    public static GameLogicDto updateGameStats(GameLogicDto gameLogicDto) {
        int playerPoint = gameLogicDto.getGameStats().getPlayerPoints();
        int computerPoint = gameLogicDto.getGameStats().getComputerPoints();
        String gameResult = gameLogicDto.getGameResult();
        switch (gameResult) {
            case Judge.PLAYER_WON_THIS_ROUND:
                playerPoint = gameLogicDto.getGameStats().getPlayerPoints() + 1;
                break;
            case Judge.COMPUTER_WON_THIS_ROUND:
                computerPoint = gameLogicDto.getGameStats().getComputerPoints() + 1;
                break;
        }
        GameStats gameStats = new GameStats(playerPoint, computerPoint, gameLogicDto.getGameStats().getNumberOfAvailableRounds() - 1);
        return new GameLogicDto(gameStats, gameLogicDto.getPlayerMovement(), gameLogicDto.getComputerMovement(), gameLogicDto.getGameResult());
    }
}
