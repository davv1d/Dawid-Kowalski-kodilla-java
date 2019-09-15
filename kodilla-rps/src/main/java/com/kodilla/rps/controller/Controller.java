package com.kodilla.rps.controller;

import com.kodilla.rps.domain.GameLogicDto;
import com.kodilla.rps.domain.GameStats;
import com.kodilla.rps.functional.Result;
import com.kodilla.rps.model.GameLogic;
import com.kodilla.rps.view.ConfirmBox;
import com.kodilla.rps.view.GameView;
import com.kodilla.rps.view.SettingsView;

public class Controller {
    private GameView gameView;
    private SettingsView settingsView;
    private GameStats gameStats;
    private GameLogic gameLogic = new GameLogic();
    private ConfirmBox confirmBox = new ConfirmBox();

    public Controller(SettingsView settingsGame) {
        settingsView = settingsGame;
    }

    public void createGameView(String userName, Integer numberOfRounds) {
        gameStats = new GameStats(0, 0, numberOfRounds);
        gameView = new GameView(this);
        gameView.display(userName, numberOfRounds);
        settingsView.closeSettingsWindow();
    }

    public void completeOneGameRound(String moveChosenByThePlayer) {
        Result<GameLogicDto> gameLogicDtoResult = gameLogic.startGame(moveChosenByThePlayer, gameStats);
        gameLogicDtoResult.forEach(this::success, this::failure);

    }

    private void failure(String s) {
        gameView.updateGameResultLabel(s);
    }

    private void success(GameLogicDto gameLogicDto) {
        gameStats = gameLogicDto.getGameStats();
        updateOfGameViewData(gameLogicDto);
        if (gameLogicDto.getGameStats().getNumberOfAvailableRounds() == 0) {
            gameView.disableTopMenuButtons();
        }
    }

    public void startNewGame() {
        boolean answer = confirmBox.display("Are you sure to start new game?");
        if (answer) {
            settingsView.openNewSettingsWindow();
            gameView.closeGameWindow();
        }
    }

    public void closeProgram() {
        boolean answer = confirmBox.display( "Are you sure you want to exit?");
        if (answer) {
            gameView.closeGameWindow();
        }
    }

    private void updateOfGameViewData(GameLogicDto gameLogicDto) {
        gameView.updateComputerPoint(gameLogicDto.getGameStats().getComputerPoints());
        gameView.updatePlayerPoint(gameLogicDto.getGameStats().getPlayerPoints());
        gameView.updateNumberOfAvailableRounds(gameLogicDto.getGameStats().getNumberOfAvailableRounds());
        gameView.updateGameResultLabel(gameLogicDto.getGameResult());
        gameView.updatePlayerMoveLabel(gameLogicDto.getPlayerMovement());
        gameView.updateComputerMoveLabel(gameLogicDto.getComputerMovement());
    }
}
