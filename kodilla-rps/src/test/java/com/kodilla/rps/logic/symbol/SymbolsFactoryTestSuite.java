package com.kodilla.rps.logic.symbol;

import com.kodilla.rps.logic.domain.SymbolsFactoryDto;
import com.kodilla.rps.logic.GameStats;
import com.kodilla.rps.logic.function.Result;
import org.junit.Test;

import java.util.Arrays;

import static com.kodilla.rps.logic.symbol.SymbolName.*;
import static com.kodilla.rps.logic.symbol.SymbolName.ROCK;
import static org.junit.Assert.*;

public class SymbolsFactoryTestSuite {

    @Test
    public void testCreateElement() {
        //Given
        Symbol rock = new Symbol(ROCK, Arrays.asList(SCISSORS, LIZARD), Arrays.asList(PAPER, SPOCK));
        Symbol paper = new Symbol(PAPER, Arrays.asList(ROCK, SPOCK), Arrays.asList(SCISSORS, LIZARD));
        Symbol scissors = new Symbol(SCISSORS, Arrays.asList(PAPER, LIZARD), Arrays.asList(ROCK, SPOCK));
        Symbol spock = new Symbol(SPOCK, Arrays.asList(SCISSORS, ROCK), Arrays.asList(LIZARD, PAPER));
        Symbol lizard = new Symbol(LIZARD, Arrays.asList(PAPER, SPOCK), Arrays.asList(SCISSORS, ROCK));
        GameStats gameStats = new GameStats(0, 0, 0);
        //When
        Result<SymbolsFactoryDto> rockResult = SymbolsFactory.makeElement(ROCK.toString(), gameStats);
        Result<SymbolsFactoryDto> paperResult = SymbolsFactory.makeElement(PAPER.toString(), gameStats);
        Result<SymbolsFactoryDto> scissorsResult = SymbolsFactory.makeElement(SCISSORS.toString(), gameStats);
        Result<SymbolsFactoryDto> spockResult = SymbolsFactory.makeElement(SPOCK.toString(), gameStats);
        Result<SymbolsFactoryDto> lizardResult = SymbolsFactory.makeElement(LIZARD.toString(), gameStats);
        //Then
        assertEquals(rock, rockResult.getOrElse(null).getPlayerSymbol());
        assertEquals(paper, paperResult.getOrElse(null).getPlayerSymbol());
        assertEquals(scissors, scissorsResult.getOrElse(null).getPlayerSymbol());
        assertEquals(spock, spockResult.getOrElse(null).getPlayerSymbol());
        assertEquals(lizard, lizardResult.getOrElse(null).getPlayerSymbol());
    }

    @Test
    public void testCreateElementNotFoundName() {
        //Given
        GameStats gameStats = new GameStats(0, 0, 0);
        //When
        Result<SymbolsFactoryDto> result = SymbolsFactory.makeElement("test", gameStats);
        //Then
        assertNull(result.getOrElse(null));
        result.forEach(System.out::println, System.out::println);
    }
}