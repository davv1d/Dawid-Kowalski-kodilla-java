package com.kodilla.rps.logic.difficulty;

import com.kodilla.rps.logic.symbol.Symbol;
import com.kodilla.rps.logic.symbol.SymbolName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DifficultyLevel {

    public List<SymbolName> getListWhereTheComputerHas50PercentChanceOfWinning(Symbol playerSymbol) {
        List<SymbolName> allSymbolsNames = new ArrayList<>();
        List<SymbolName> symbolsThatWillGiveADraw = multiplyTheSelectedSymbolSpecifiedNumbersOfTimes(playerSymbol.getSymbolsNamesWhichDefeatMe().size(), Collections.singletonList(playerSymbol.getName()));
        List<SymbolName> symbolsThatWillGiveTheComputerVictory = multiplyTheSelectedSymbolSpecifiedNumbersOfTimes(2, playerSymbol.getSymbolsNamesWhichDefeatMe());
        List<SymbolName> symbolsThatBringComputerFailure = playerSymbol.getSymbolsNamesThatIOvercomes();
        allSymbolsNames.addAll(symbolsThatWillGiveADraw);
        allSymbolsNames.addAll(symbolsThatWillGiveTheComputerVictory);
        allSymbolsNames.addAll(symbolsThatBringComputerFailure);
        return allSymbolsNames;
    }

    private List<SymbolName> multiplyTheSelectedSymbolSpecifiedNumbersOfTimes(int number, List<SymbolName> symbolNames) {
        List<SymbolName> names = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            names.addAll(symbolNames);
        }
        return names;
    }
}
