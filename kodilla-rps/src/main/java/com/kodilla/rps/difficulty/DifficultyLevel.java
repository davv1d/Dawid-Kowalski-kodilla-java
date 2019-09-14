package com.kodilla.rps.difficulty;

import com.kodilla.rps.elements.Element;
import com.kodilla.rps.elements.ElementName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DifficultyLevel {

    public static List<ElementName> getListWhereTheComputerHas50PercentChanceOfWinning(Element playerElement) {
        List<ElementName> elements = multiplyTheSelectedElementSpecifiedNumbersOfTimes(
                playerElement.getElementsWhichDefeatMe().size(),
                Collections.singletonList(playerElement.getName()));
        elements.addAll(multiplyTheSelectedElementSpecifiedNumbersOfTimes(2, playerElement.getElementsWhichDefeatMe()));
        elements.addAll(playerElement.getElementsThatIOvercomes());
        return elements;
    }

    private static List<ElementName> multiplyTheSelectedElementSpecifiedNumbersOfTimes(int number, List<ElementName> names) {
        List<ElementName> elements = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            elements.addAll(names);
        }
        return elements;
    }
}
