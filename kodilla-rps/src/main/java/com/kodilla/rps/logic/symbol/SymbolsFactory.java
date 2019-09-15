package com.kodilla.rps.logic.symbol;

import com.kodilla.rps.logic.domain.SymbolsFactoryDto;
import com.kodilla.rps.logic.GameStats;
import com.kodilla.rps.logic.function.Result;
import com.kodilla.rps.logic.constant.ErrorInTheGame;

import java.util.Arrays;

import static com.kodilla.rps.logic.symbol.SymbolName.*;

public class SymbolsFactory {
    public static Result<SymbolsFactoryDto> makeElement(String symbolChosenByThePlayer, GameStats gameStats) {
        Symbol symbol;
        if (symbolChosenByThePlayer.equals(ROCK.toString())) {
            symbol = new Symbol(ROCK, Arrays.asList(SCISSORS, LIZARD), Arrays.asList(PAPER, SPOCK));
        } else if (symbolChosenByThePlayer.equals(PAPER.toString())) {
            symbol = new Symbol(PAPER, Arrays.asList(ROCK, SPOCK), Arrays.asList(SCISSORS, LIZARD));
        } else if (symbolChosenByThePlayer.equals(SCISSORS.toString())) {
            symbol = new Symbol(SCISSORS, Arrays.asList(PAPER, LIZARD), Arrays.asList(ROCK, SPOCK));
        } else if (symbolChosenByThePlayer.equals(SPOCK.toString())) {
            symbol = new Symbol(SPOCK, Arrays.asList(SCISSORS, ROCK), Arrays.asList(LIZARD, PAPER));
        } else if (symbolChosenByThePlayer.equals(LIZARD.toString())) {
            symbol = new Symbol(LIZARD, Arrays.asList(PAPER, SPOCK), Arrays.asList(SCISSORS, ROCK));
        } else {
            return Result.failure(SymbolsFactory.class + " " + ErrorInTheGame.errorNotFoundSymbolName().getValue());
        }
        return Result.success(new SymbolsFactoryDto(symbol, gameStats));
    }
}
