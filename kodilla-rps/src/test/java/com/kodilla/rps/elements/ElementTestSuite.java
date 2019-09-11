package com.kodilla.rps.elements;

import org.junit.Test;

import java.util.Collections;

import static com.kodilla.rps.elements.ElementName.*;
import static org.junit.Assert.*;

public class ElementTestSuite {

    @Test
    public void testCreateElement() {
        //Given and When
        Element element = new Element(ROCK, Collections.singletonList(SCISSORS), Collections.singletonList(PAPER));
        //Then
        assertEquals(ROCK, element.getName());
        assertEquals(Collections.singletonList(SCISSORS), element.getElementsThatIOvercomes());
        assertEquals(Collections.singletonList(PAPER), element.getElementsWhichDefeatMe());
    }
}