package com.kodilla.rps.elements;

import com.kodilla.rps.domain.FactoryElementDto;
import com.kodilla.rps.domain.GameStats;
import com.kodilla.rps.functional.Result;

import java.util.Arrays;

import static com.kodilla.rps.elements.ElementName.*;

public class ElementsFactory {
    public static Result<FactoryElementDto> makeElement(String date, GameStats gameStats) {
        Element element;
        if (date.equals(ROCK.toString())) {
            element = new Element(ROCK, Arrays.asList(SCISSORS, LIZARD), Arrays.asList(PAPER, SPOCK));
        } else if (date.equals(PAPER.toString())) {
            element = new Element(PAPER, Arrays.asList(ROCK, SPOCK), Arrays.asList(SCISSORS, LIZARD));
        } else if (date.equals(SCISSORS.toString())) {
            element = new Element(SCISSORS, Arrays.asList(PAPER, LIZARD), Arrays.asList(ROCK, SPOCK));
        } else if (date.equals(SPOCK.toString())) {
            element = new Element(SPOCK, Arrays.asList(SCISSORS, ROCK), Arrays.asList(LIZARD, PAPER));
        } else if (date.equals(LIZARD.toString())) {
            element = new Element(LIZARD, Arrays.asList(PAPER, SPOCK), Arrays.asList(SCISSORS, ROCK));
        } else {
            return Result.failure("Error not found name");
        }
        return Result.success(new FactoryElementDto(element, gameStats));
    }
}
