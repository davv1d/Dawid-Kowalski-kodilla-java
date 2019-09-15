package com.kodilla.rps.computer;

import com.kodilla.rps.difficulty.DifficultyLevel;
import com.kodilla.rps.domain.ComputerDto;
import com.kodilla.rps.domain.FactoryElementDto;
import com.kodilla.rps.elements.ElementName;
import com.kodilla.rps.functional.Result;

import java.util.List;
import java.util.Random;

public class Computer {
    private Random random = new Random();

    //if elementsToChoose is empty error dependencies
    public Result<ComputerDto> getElementSelectedByComputer(FactoryElementDto factoryElementDto) {
        List<ElementName> elementsToChoose = DifficultyLevel.getListWhereTheComputerHas50PercentChanceOfWinning(factoryElementDto.getPlayerElement());
        if (elementsToChoose.isEmpty()) {
            return Result.failure("Error in dependencies");
        } else {
            int theNumberDrawn = random.nextInt(elementsToChoose.size());
            return Result.success(new ComputerDto(factoryElementDto.getPlayerElement(), factoryElementDto.getGameStats(), elementsToChoose.get(theNumberDrawn)));
        }
    }
}
