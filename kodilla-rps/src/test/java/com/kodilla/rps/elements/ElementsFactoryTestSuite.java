package com.kodilla.rps.elements;

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
        Element rockResult = null, paperResult = null, scissorsResult = null, spockResult = null, lizardResult = null;
        //When
        try {
            rockResult = ElementsFactory.makeElement(ROCK.toString(), gameStats);
            paperResult = ElementsFactory.makeElement(PAPER.toString(), gameStats);
            scissorsResult = ElementsFactory.makeElement(SCISSORS.toString(), gameStats);
            spockResult = ElementsFactory.makeElement(SPOCK.toString(), gameStats);
            lizardResult = ElementsFactory.makeElement(LIZARD.toString(), gameStats);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Then
        assertEquals(rock, rockResult);
        assertEquals(paper, paperResult);
        assertEquals(scissors, scissorsResult);
        assertEquals(spock, spockResult);
        assertEquals(lizard, lizardResult);
    }

    @Test
    public void testCreateElementNotFoundName() {
        //Given and When
        Element result = ElementsFactory.makeElement("test", gameStats);
        //Then
        assertEquals(ERROR_NOT_FOUND_NAME, result.getName());
        assertEquals(0, result.getElementsWhichDefeatMe().size());
        assertEquals(0, result.getElementsThatIOvercomes().size());
    }
}