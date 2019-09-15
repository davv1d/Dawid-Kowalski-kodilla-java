package com.kodilla.rps.logic.computer;

import com.kodilla.rps.logic.constant.ErrorInTheGame;
import com.kodilla.rps.logic.difficulty.DifficultyLevel;
import com.kodilla.rps.logic.domain.ComputerDto;
import com.kodilla.rps.logic.domain.SymbolsFactoryDto;
import com.kodilla.rps.logic.function.Result;
import com.kodilla.rps.logic.symbol.SymbolName;

import java.util.List;
import java.util.Random;

public class Computer {
    private Random random = new Random();
    private DifficultyLevel level = new DifficultyLevel();

    public Result<ComputerDto> selectTheComputerSymbol(SymbolsFactoryDto symbolsFactoryDto) {
        List<SymbolName> symbolsToChoose = level.getListWhereTheComputerHas50PercentChanceOfWinning(symbolsFactoryDto.getPlayerSymbol());
        if (symbolsToChoose.isEmpty()) {
            return Result.failure(Computer.class + " " + ErrorInTheGame.errorInDependenciesAmongSymbols().getValue());
        } else {
            int theNumberDrawn = random.nextInt(symbolsToChoose.size());
            return Result.success(new ComputerDto(symbolsFactoryDto.getPlayerSymbol(), symbolsFactoryDto.getGameStats(), symbolsToChoose.get(theNumberDrawn)));
        }
    }
}
