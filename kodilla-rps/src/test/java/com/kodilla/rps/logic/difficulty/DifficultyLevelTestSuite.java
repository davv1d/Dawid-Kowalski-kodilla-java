package com.kodilla.rps.logic.difficulty;

import com.kodilla.rps.logic.symbol.Symbol;
import com.kodilla.rps.logic.symbol.SymbolName;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.kodilla.rps.logic.symbol.SymbolName.*;
import static org.junit.Assert.*;

public class DifficultyLevelTestSuite {

    @Test
    public void testGetListWhereTheComputerHas50PercentChanceOfWinning() {
        //Given
        DifficultyLevel level = new DifficultyLevel();
        Symbol symbol = new Symbol(ROCK, Arrays.asList(SCISSORS, LIZARD), Arrays.asList(PAPER, SPOCK));
        //When
        List<SymbolName> result = level.getListWhereTheComputerHas50PercentChanceOfWinning(symbol);
        //Then
        double numberOfWinningNames = result.stream()
                .filter(elementNames -> elementNames.equals(PAPER) || elementNames.equals(SPOCK))
                .mapToInt(value -> 1)
                .count();
        double numberOfDrawingNames = result.stream()
                .filter(elementNames -> elementNames.equals(ROCK))
                .mapToInt(value -> 1)
                .count();
        double numberOfLosingNames = result.stream()
                .filter(elementNames -> elementNames.equals(SCISSORS) || elementNames.equals(LIZARD))
                .mapToInt(value -> 1)
                .count();
        assertEquals(0.5, numberOfWinningNames/result.size(), 0);
        assertEquals(0.25, numberOfDrawingNames/result.size(), 0);
        assertEquals(0.25, numberOfLosingNames/result.size(), 0);
    }
}