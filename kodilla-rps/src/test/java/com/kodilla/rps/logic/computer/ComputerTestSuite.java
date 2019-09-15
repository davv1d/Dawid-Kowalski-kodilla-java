package com.kodilla.rps.logic.computer;

import com.kodilla.rps.logic.domain.ComputerDto;
import com.kodilla.rps.logic.domain.SymbolsFactoryDto;
import com.kodilla.rps.logic.GameStats;
import com.kodilla.rps.logic.symbol.Symbol;
import com.kodilla.rps.logic.function.Result;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.kodilla.rps.logic.symbol.SymbolName.*;
import static org.junit.Assert.*;

public class ComputerTestSuite {
    private Computer computer = new Computer();
    @Test
    public void testSelectTheComputerSymbol() {
        //Given
        Symbol playerSymbol = new Symbol(ROCK, Arrays.asList(SCISSORS, LIZARD), Arrays.asList(PAPER, SPOCK));
        GameStats gameStats = new GameStats(0, 0, 0);
        SymbolsFactoryDto symbolsFactoryDto = new SymbolsFactoryDto(playerSymbol, gameStats);
        //When
        Result<ComputerDto> result = computer.selectTheComputerSymbol(symbolsFactoryDto);
        //Then
        assertNotNull(result.getOrElse(null));
    }

    @Test
    public void testSelectTheComputerSymbolEmptyListToDraw() {
        //Given
        Symbol playerSymbol = new Symbol(ROCK, Collections.emptyList(), Collections.emptyList());
        GameStats gameStats = new GameStats(0, 0, 0);
        SymbolsFactoryDto symbolsFactoryDto = new SymbolsFactoryDto(playerSymbol, gameStats);
        //When
        Result<ComputerDto> result = computer.selectTheComputerSymbol(symbolsFactoryDto);
        //Then
        assertNull(result.getOrElse(null));
        result.forEach(System.out::println, System.out::println);
    }

}