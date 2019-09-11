package com.kodilla.rps.judge;

import com.kodilla.rps.computer.Computer;
import com.kodilla.rps.elements.Element;
import org.junit.Test;

import java.util.Arrays;

import static com.kodilla.rps.elements.ElementName.*;
import static org.junit.Assert.*;

public class JudgeTestSuite {

    @Test
    public void testCheckWhoWin() {
        //Given
        Element playerElement = new Element(ROCK, Arrays.asList(SCISSORS, LIZARD), Arrays.asList(PAPER, SPOCK));
        Judge judge = new Judge();
        //When
        String draw = judge.checkWhoWin(playerElement, ROCK);
        String playerWin1 = judge.checkWhoWin(playerElement, SCISSORS);
        String playerWin2 = judge.checkWhoWin(playerElement, LIZARD);
        String playerLose1 = judge.checkWhoWin(playerElement, PAPER);
        String playerLose2 = judge.checkWhoWin(playerElement, SPOCK);
        String error = judge.checkWhoWin(playerElement, ERROR);
        //Then
        assertEquals(Judge.DRAW, draw);
        assertEquals(Judge.PLAYER, playerWin1);
        assertEquals(Judge.PLAYER, playerWin2);
        assertEquals(Judge.COMPUTER, playerLose1);
        assertEquals(Judge.COMPUTER, playerLose2);
        assertEquals(Judge.ERROR, error);
    }
}