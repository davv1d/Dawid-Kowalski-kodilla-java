package com.kodilla.rps.computer;

import com.kodilla.rps.domain.ComputerDto;
import com.kodilla.rps.domain.FactoryElementDto;
import com.kodilla.rps.domain.GameStats;
import com.kodilla.rps.elements.Element;
import com.kodilla.rps.elements.ElementName;
import com.kodilla.rps.functional.Result;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.kodilla.rps.elements.ElementName.*;
import static org.junit.Assert.*;

public class ComputerTestSuite {
    private Computer computer = new Computer();
    @Test
    public void testElementSelectedByComputer() {
        //Given
        Element playerElement = new Element(ROCK, Arrays.asList(SCISSORS, LIZARD), Arrays.asList(PAPER, SPOCK));
        GameStats gameStats = new GameStats(0, 0, 0);
        FactoryElementDto factoryElementDto = new FactoryElementDto(playerElement, gameStats);
        //When
        Result<ComputerDto> result = computer.getElementSelectedByComputer(factoryElementDto);
        //Then
        assertNotNull(result.getOrElse(null));
    }

    @Test
    public void testElementSelectedByComputerEmptyListToDraw() {
        //Given
        Element playerElement = new Element(ROCK, Collections.emptyList(), Collections.emptyList());
        GameStats gameStats = new GameStats(0, 0, 0);
        FactoryElementDto factoryElementDto = new FactoryElementDto(playerElement, gameStats);
        //When
        Result<ComputerDto> result = computer.getElementSelectedByComputer(factoryElementDto);
        //Then
        assertNull(result.getOrElse(null));
        result.forEach(System.out::println, System.out::println);
    }

}