package com.kodilla.rps.logic.symbol;

import org.junit.Test;

import java.util.Collections;

import static com.kodilla.rps.logic.symbol.SymbolName.*;
import static org.junit.Assert.*;

public class SymbolTestSuite {

    @Test
    public void testCreateElement() {
        //Given and When
        Symbol symbol = new Symbol(ROCK, Collections.singletonList(SCISSORS), Collections.singletonList(PAPER));
        //Then
        assertEquals(ROCK, symbol.getName());
        assertEquals(Collections.singletonList(SCISSORS), symbol.getSymbolsNamesThatIOvercomes());
        assertEquals(Collections.singletonList(PAPER), symbol.getSymbolsNamesWhichDefeatMe());
    }
}