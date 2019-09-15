package com.kodilla.rps.difficulty;

import com.kodilla.rps.elements.Element;
import com.kodilla.rps.elements.ElementName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DifficultyLevel {

    public List<ElementName> getListWhereTheComputerHas50PercentChanceOfWinning(Element playerElement) {
        List<ElementName> allElements = new ArrayList<>();
        List<ElementName> elementsThatWillGiveADraw = multiplyTheSelectedElementSpecifiedNumbersOfTimes(playerElement.getElementsWhichDefeatMe().size(), Collections.singletonList(playerElement.getName()));
        List<ElementName> elementsThatWillGiveTheComputerVictory = multiplyTheSelectedElementSpecifiedNumbersOfTimes(2, playerElement.getElementsWhichDefeatMe());
        List<ElementName> elementsThatWillFailYourComputer = playerElement.getElementsThatIOvercomes();
        allElements.addAll(elementsThatWillGiveADraw);
        allElements.addAll(elementsThatWillGiveTheComputerVictory);
        allElements.addAll(elementsThatWillFailYourComputer);
        return allElements;
    }

    private List<ElementName> multiplyTheSelectedElementSpecifiedNumbersOfTimes(int number, List<ElementName> names) {
        List<ElementName> elements = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            elements.addAll(names);
        }
        return elements;
    }
}
