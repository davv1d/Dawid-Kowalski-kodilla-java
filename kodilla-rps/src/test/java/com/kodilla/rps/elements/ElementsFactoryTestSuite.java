package com.kodilla.rps.elements;

import com.kodilla.rps.domain.FactoryElementDto;
import com.kodilla.rps.domain.GameStats;
import com.kodilla.rps.functional.Result;
import org.junit.Test;

import java.util.Arrays;

import static com.kodilla.rps.elements.ElementName.*;
import static com.kodilla.rps.elements.ElementName.ROCK;
import static org.junit.Assert.*;

public class ElementsFactoryTestSuite {

    @Test
    public void testCreateElement() {
        //Given
        Element rock = new Element(ROCK, Arrays.asList(SCISSORS, LIZARD), Arrays.asList(PAPER, SPOCK));
        Element paper = new Element(PAPER, Arrays.asList(ROCK, SPOCK), Arrays.asList(SCISSORS, LIZARD));
        Element scissors = new Element(SCISSORS, Arrays.asList(PAPER, LIZARD), Arrays.asList(ROCK, SPOCK));
        Element spock = new Element(SPOCK, Arrays.asList(SCISSORS, ROCK), Arrays.asList(LIZARD, PAPER));
        Element lizard = new Element(LIZARD, Arrays.asList(PAPER, SPOCK), Arrays.asList(SCISSORS, ROCK));
        GameStats gameStats = new GameStats(0, 0, 0);
        //When
        Result<FactoryElementDto> rockResult = ElementsFactory.makeElement(ROCK.toString(), gameStats);
        Result<FactoryElementDto> paperResult = ElementsFactory.makeElement(PAPER.toString(), gameStats);
        Result<FactoryElementDto> scissorsResult = ElementsFactory.makeElement(SCISSORS.toString(), gameStats);
        Result<FactoryElementDto> spockResult = ElementsFactory.makeElement(SPOCK.toString(), gameStats);
        Result<FactoryElementDto> lizardResult = ElementsFactory.makeElement(LIZARD.toString(), gameStats);
        //Then
        assertEquals(rock, rockResult.getOrElse(null).getPlayerElement());
        assertEquals(paper, paperResult.getOrElse(null).getPlayerElement());
        assertEquals(scissors, scissorsResult.getOrElse(null).getPlayerElement());
        assertEquals(spock, spockResult.getOrElse(null).getPlayerElement());
        assertEquals(lizard, lizardResult.getOrElse(null).getPlayerElement());
    }

    @Test
    public void testCreateElementNotFoundName() {
        //Given
        GameStats gameStats = new GameStats(0, 0, 0);
        //When
        Result<FactoryElementDto> result = ElementsFactory.makeElement("test", gameStats);
        //Then
        assertNull(result.getOrElse(null));
        result.forEach(System.out::println, System.out::println);
    }
}