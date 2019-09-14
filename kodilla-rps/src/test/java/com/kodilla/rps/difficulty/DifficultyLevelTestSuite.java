package com.kodilla.rps.difficulty;

import com.kodilla.rps.elements.Element;
import com.kodilla.rps.elements.ElementName;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.kodilla.rps.elements.ElementName.*;
import static org.junit.Assert.*;

public class DifficultyLevelTestSuite {

    @Test
    public void testGetListWhereTheComputerHas50PercentChanceOfWinning() {
        //Given
        Element element = new Element(ROCK, Arrays.asList(SCISSORS, LIZARD), Arrays.asList(PAPER, SPOCK));
        //When
        List<ElementName> result = DifficultyLevel.getListWhereTheComputerHas50PercentChanceOfWinning(element);
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