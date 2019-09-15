package com.kodilla.rps.logic;

import com.kodilla.rps.logic.domain.GameLogicDto;
import com.kodilla.rps.logic.function.Result;
import com.kodilla.rps.logic.constant.ErrorInTheGame;
import com.kodilla.rps.logic.constant.GameRoundResult;
import org.junit.Test;

import static com.kodilla.rps.logic.symbol.SymbolName.ROCK;
import static com.kodilla.rps.logic.symbol.SymbolName.SCISSORS;
import static org.junit.Assert.*;

public class GameStatsUpdaterTestSuite {
    private GameStatsUpdater updater = new GameStatsUpdater();
    @Test
    public void testUpdateGameStatsAfterRound() {
        //Given
        GameStats gameStats = new GameStats(1,0,2);
        GameLogicDto gameLogicDto = new GameLogicDto(gameStats, ROCK, SCISSORS, GameRoundResult.playerWonThisRound());
        //When
        Result<GameLogicDto> gameLogicDtoResult = updater.updateGameStatsAfterRound(gameLogicDto);
        //Then
        assertNotNull(gameLogicDtoResult.getOrElse(null));
        assertEquals(2, gameLogicDtoResult.getOrElse(null).getGameStats().getPlayerPoints());
        assertEquals(0, gameLogicDtoResult.getOrElse(null).getGameStats().getComputerPoints());
        assertEquals(1, gameLogicDtoResult.getOrElse(null).getGameStats().getNumberOfAvailableRounds());
    }

    @Test
    public void testUpdateGameStatsAfterRoundNotRecognizeGameResult() {
        //Given
        GameStats gameStats = new GameStats(1,0,2);
        GameLogicDto gameLogicDto = new GameLogicDto(gameStats, ROCK, SCISSORS, ErrorInTheGame.errorNotFoundSymbolName());
        //When
        Result<GameLogicDto> gameLogicDtoResult = updater.updateGameStatsAfterRound(gameLogicDto);
        //Then
        assertNull(gameLogicDtoResult.getOrElse(null));
        gameLogicDtoResult.forEach(System.out::println, System.out::println);
    }

}