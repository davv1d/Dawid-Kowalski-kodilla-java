package com.kodilla.rps;

import com.kodilla.rps.computer.Computer;
import com.kodilla.rps.elements.Element;
import com.kodilla.rps.elements.ElementCreateException;
import com.kodilla.rps.elements.ElementName;
import com.kodilla.rps.elements.ElementsFactory;
import com.kodilla.rps.judge.Judge;

public class Game {

    public static void play(String keyPushFromPlayer) {
        Element playerElement;
        try {
            playerElement = ElementsFactory.creatingAnElementBasedOnTheGivenDate(keyPushFromPlayer);
            ElementName computerElement = new Computer().elementSelectedByComputer(playerElement);
            String result = new Judge().checkWhoWin(playerElement, computerElement);
        } catch (ElementCreateException e) {
            System.out.println(e.getMessage());
        }
    }
}
