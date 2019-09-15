package com.kodilla.rps.judge;

import com.kodilla.rps.domain.ComputerDto;
import com.kodilla.rps.domain.GameLogicDto;
import com.kodilla.rps.functional.Result;

public class Judge {
    public static final String PLAYER_WON_THIS_ROUND = "Player won this round";
    public static final String COMPUTER_WON_THIS_ROUND = "Computer won this round";
    public static final String DRAW_IN_ROUND = "Draw this time";
    public static final String ERROR_IN_DEPENDENCIES = "ERROR in dependencies among elements";
    private static final String PLAYER_WON_GAME = "Player won game";
    private static final String COMPUTER_WON_GAME = "Computer won game";
    private static final String DRAW_IN_GAME = "Draw in this game";

    //not error in this place
    public Result<GameLogicDto> checkWhoWinRound(ComputerDto computerDto) {
        String resultGame;
        if (computerDto.getPlayerElement().getElementsWhichDefeatMe().contains(computerDto.getComputerElementName())) {
            resultGame = COMPUTER_WON_THIS_ROUND;
        } else if (computerDto.getPlayerElement().getElementsThatIOvercomes().contains(computerDto.getComputerElementName())) {
            resultGame = PLAYER_WON_THIS_ROUND;
        } else if (computerDto.getPlayerElement().getName().equals(computerDto.getComputerElementName())) {
            resultGame = DRAW_IN_ROUND;
        } else {
            return Result.failure(ERROR_IN_DEPENDENCIES);
        }
        return Result.success(new GameLogicDto(
                computerDto.getGameStats(),
                computerDto.getPlayerElement().getName().toString(),
                computerDto.getComputerElementName().toString(),
                resultGame));
    }

    public GameLogicDto checkIfSomeoneHasWonTheGame(GameLogicDto gameLogicDto) {
        String resultGame;
        if (gameLogicDto.getGameStats().getNumberOfAvailableRounds() == 0) {
            if (gameLogicDto.getGameStats().getPlayerPoints() > gameLogicDto.getGameStats().getComputerPoints()) {
                resultGame = PLAYER_WON_GAME;
            } else if (gameLogicDto.getGameStats().getComputerPoints() > gameLogicDto.getGameStats().getPlayerPoints()) {
                resultGame = COMPUTER_WON_GAME;
            } else {
                resultGame = DRAW_IN_GAME;
            }
            return new GameLogicDto(gameLogicDto.getGameStats(), gameLogicDto.getPlayerMovement(), gameLogicDto.getComputerMovement(), resultGame);
        } else {
            return gameLogicDto;
        }
    }
}
