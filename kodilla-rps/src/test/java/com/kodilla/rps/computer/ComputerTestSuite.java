package com.kodilla.rps.computer;

import com.kodilla.rps.elements.Element;
import com.kodilla.rps.elements.ElementName;
import org.junit.Test;

import java.util.Arrays;

import static com.kodilla.rps.elements.ElementName.*;

public class ComputerTestSuite {

    @Test
    public void testElementSelectedByComputer() {
        //Given
        Element playerElement = new Element(ROCK, Arrays.asList(SCISSORS, LIZARD), Arrays.asList(PAPER, SPOCK));
        Computer computer = new Computer();
        //When
        ElementName elementComputerName = computer.elementSelectedByComputer(playerElement);
        //Then
        System.out.println(elementComputerName);
    }

}