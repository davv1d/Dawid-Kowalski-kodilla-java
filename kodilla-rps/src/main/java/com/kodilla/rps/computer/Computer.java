package com.kodilla.rps.computer;

import com.kodilla.rps.difficulty.DifficultyLevel;
import com.kodilla.rps.elements.Element;
import com.kodilla.rps.elements.ElementName;

import java.util.List;
import java.util.Random;

public class Computer {
    private Random random = new Random();

    public ElementName getElementSelectedByComputer(Element playerElement) {
        List<ElementName> elementsToChoose = DifficultyLevel.getListWhereTheComputerHas50PercentChanceOfWinning(playerElement);
        int theMumberDrawn = random.nextInt(elementsToChoose.size());
        return elementsToChoose.get(theMumberDrawn);
    }
}
