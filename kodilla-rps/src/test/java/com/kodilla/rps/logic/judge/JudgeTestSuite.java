package com.kodilla.rps.logic.judge;

import com.kodilla.rps.logic.domain.ComputerDto;
import com.kodilla.rps.logic.domain.GameLogicDto;
import com.kodilla.rps.logic.GameStats;
import com.kodilla.rps.logic.symbol.Symbol;
import com.kodilla.rps.logic.function.Result;
import com.kodilla.rps.logic.constant.GameResult;
import com.kodilla.rps.logic.constant.GameRoundResult;
import org.junit.Test;

import java.util.Arrays;

import static com.kodilla.rps.logic.symbol.SymbolName.*;
import static org.junit.Assert.*;

public class JudgeTestSuite {
    private Judge judge = new Judge();

    @Test
    public void testCheckWhoWin() {
        //Given
        GameStats gameStats = new GameStats(0, 0, 0);
        Symbol playerSymbol = new Symbol(ROCK, Arrays.asList(SCISSORS, LIZARD), Arrays.asList(PAPER, SPOCK));
        //When
        Result<GameLogicDto> drawResult = judge.checkWhoWinRound(new ComputerDto(playerSymbol, gameStats, ROCK));
        Result<GameLogicDto> playerWin1Result = judge.checkWhoWinRound(new ComputerDto(playerSymbol, gameStats, SCISSORS));
        Result<GameLogicDto> playerWin2Result = judge.checkWhoWinRound(new ComputerDto(playerSymbol, gameStats, LIZARD));
        Result<GameLogicDto> playerLose1Result = judge.checkWhoWinRound(new ComputerDto(playerSymbol, gameStats, PAPER));
        Result<GameLogicDto> playerLose2Result = judge.checkWhoWinRound(new ComputerDto(playerSymbol, gameStats, SPOCK));
        //Then
        assertEquals(GameRoundResult.drawInRound(), drawResult.getOrElse(null).getGameResult());
        assertEquals(GameRoundResult.playerWonThisRound(), playerWin1Result.getOrElse(null).getGameResult());
        assertEquals(GameRoundResult.playerWonThisRound(), playerWin2Result.getOrElse(null).getGameResult());
        assertEquals(GameRoundResult.computerWonThisRound(), playerLose1Result.getOrElse(null).getGameResult());
        assertEquals(GameRoundResult.computerWonThisRound(), playerLose2Result.getOrElse(null).getGameResult());
    }

    @Test
    public void testCheckWhoWinError() {
        //Given
        GameStats gameStats = new GameStats(0, 0, 0);
        Symbol playerSymbol = new Symbol(ROCK, Arrays.asList(SCISSORS, LIZARD), Arrays.asList(PAPER, SPOCK));
        //When
        Result<GameLogicDto> errorResult = judge.checkWhoWinRound(new ComputerDto(playerSymbol, gameStats, TEST_NAME));
        //Then
        assertNull(errorResult.getOrElse(null));
        errorResult.forEach(System.out::println, System.out::println);
    }

    @Test
    public void testCheckIfSomeoneHasWonTheGameExamplePlayerWon() {
        //Given
        GameStats gameStats = new GameStats(1, 0, 0);
        GameLogicDto gameLogicDto = new GameLogicDto(gameStats, ROCK, SCISSORS, GameRoundResult.playerWonThisRound());
        //When
        GameLogicDto gameLogicDtoResult = judge.checkIfSomeoneHasWonTheGame(gameLogicDto);
        //Then
        assertEquals(GameResult.playerWonGame(), gameLogicDtoResult.getGameResult());
    }

    @Test
    public void testCheckIfSomeoneHasWonTheGameExampleComputerWon() {
        //Given
        GameStats gameStats = new GameStats(0, 2, 0);
        GameLogicDto gameLogicDto = new GameLogicDto(gameStats, SCISSORS, ROCK, GameRoundResult.computerWonThisRound());
        //When
        GameLogicDto gameLogicDtoResult = judge.checkIfSomeoneHasWonTheGame(gameLogicDto);
        //Then
        assertEquals(GameResult.computerWonGame(), gameLogicDtoResult.getGameResult());
    }

    @Test
    public void testCheckIfSomeoneHasWonTheGameExampleDraw() {
        //Given
        GameStats gameStats = new GameStats(0, 0, 0);
        GameLogicDto gameLogicDto = new GameLogicDto(gameStats, ROCK, ROCK, GameRoundResult.drawInRound());
        //When
        GameLogicDto gameLogicDtoResult = judge.checkIfSomeoneHasWonTheGame(gameLogicDto);
        //Then
        assertEquals(GameResult.drawInGame(), gameLogicDtoResult.getGameResult());
    }

    @Test
    public void testCheckIfSomeoneHasWonTheGameAvailableRounds() {
        //Given
        GameStats gameStats = new GameStats(0, 3, 2);
        GameLogicDto gameLogicDto = new GameLogicDto(gameStats, SCISSORS, ROCK, GameRoundResult.computerWonThisRound());
        //When
        GameLogicDto gameLogicDtoResult = judge.checkIfSomeoneHasWonTheGame(gameLogicDto);
        //Then
        assertEquals(GameRoundResult.computerWonThisRound(), gameLogicDtoResult.getGameResult());
    }
}