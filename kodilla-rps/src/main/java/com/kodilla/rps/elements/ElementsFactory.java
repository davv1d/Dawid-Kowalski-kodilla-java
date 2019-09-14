package com.kodilla.rps.elements;

import java.util.Arrays;
import java.util.Collections;

import static com.kodilla.rps.elements.ElementName.*;

public class ElementsFactory {
    public static Element creatingAnElementBasedOnTheGivenDate(String date) {
        if (date.equals(ROCK.toString())) {
            return new Element(ROCK, Arrays.asList(SCISSORS, LIZARD), Arrays.asList(PAPER, SPOCK));
        } else if (date.equals(PAPER.toString())) {
            return new Element(PAPER, Arrays.asList(ROCK, SPOCK), Arrays.asList(SCISSORS, LIZARD));
        } else if (date.equals(SCISSORS.toString())) {
            return new Element(SCISSORS, Arrays.asList(PAPER, LIZARD), Arrays.asList(ROCK, SPOCK));
        } else if (date.equals(SPOCK.toString())) {
            return new Element(SPOCK, Arrays.asList(SCISSORS, ROCK), Arrays.asList(LIZARD, PAPER));
        } else if (date.equals(LIZARD.toString())) {
            return new Element(LIZARD, Arrays.asList(PAPER, SPOCK), Arrays.asList(SCISSORS, ROCK));
        } else {
            return new Element(ERROR, Collections.emptyList(), Collections.emptyList());
        }
    }
}
