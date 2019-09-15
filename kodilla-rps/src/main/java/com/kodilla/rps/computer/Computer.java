package com.kodilla.rps.computer;

import com.kodilla.rps.difficulty.DifficultyLevel;
import com.kodilla.rps.domain.ComputerDto;
import com.kodilla.rps.domain.FactoryElementDto;
import com.kodilla.rps.elements.ElementName;
import com.kodilla.rps.functional.Result;
import com.kodilla.rps.constant.ErrorInGame;

import java.util.List;
import java.util.Random;

public class Computer {
    private Random random = new Random();
    private DifficultyLevel level = new DifficultyLevel();

    public Result<ComputerDto> getElementSelectedByComputer(FactoryElementDto factoryElementDto) {
        List<ElementName> elementsToChoose = level.getListWhereTheComputerHas50PercentChanceOfWinning(factoryElementDto.getPlayerElement());
        if (elementsToChoose.isEmpty()) {
            return Result.failure(ErrorInGame.errorInDependenciesAmongElement().getValue());
        } else {
            int theNumberDrawn = random.nextInt(elementsToChoose.size());
            return Result.success(new ComputerDto(factoryElementDto.getPlayerElement(), factoryElementDto.getGameStats(), elementsToChoose.get(theNumberDrawn)));
        }
    }
}
