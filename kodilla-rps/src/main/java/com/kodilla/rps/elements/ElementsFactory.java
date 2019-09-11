package com.kodilla.rps.elements;

import java.util.Arrays;

import static com.kodilla.rps.elements.ElementName.*;

public class ElementsFactory {
    public static Element creatingAnElementBasedOnTheGivenDate(String date) throws ElementCreateException {
        switch (date) {
            case "1":
                return new Element(ROCK, Arrays.asList(SCISSORS, LIZARD), Arrays.asList(PAPER, SPOCK));
            case "2":
                return new Element(PAPER, Arrays.asList(ROCK, SPOCK), Arrays.asList(SCISSORS, LIZARD));
            case "3":
                return new Element(SCISSORS, Arrays.asList(PAPER, LIZARD), Arrays.asList(ROCK, SPOCK));
            case "4":
                return new Element(SPOCK, Arrays.asList(SCISSORS, ROCK), Arrays.asList(LIZARD, PAPER));
            case "5":
                return new Element(LIZARD, Arrays.asList(PAPER, SPOCK), Arrays.asList(SCISSORS, ROCK));
            default:
                throw new ElementCreateException("Not correct name");
        }
    }
}
