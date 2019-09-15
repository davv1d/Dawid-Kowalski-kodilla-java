package com.kodilla.rps.controller;

import com.kodilla.rps.MainView;
import com.kodilla.rps.logic.GameLogic;
import com.kodilla.rps.logic.GameStats;
import com.kodilla.rps.logic.domain.GameLogicDto;
import com.kodilla.rps.view.ConfirmBoxView;
import com.kodilla.rps.view.GameView;

public class Controller {
    private GameView gameView;
    private MainView mainView;
    private GameStats gameStats;
    private GameLogic gameLogic = new GameLogic();
    private ConfirmBoxView confirmBoxView = new ConfirmBoxView();

    public Controller(MainView mainView) {
        this.mainView = mainView;
    }

    public void createGameView(String userName, Integer numberOfRounds) {
        gameStats = new GameStats(0, 0, numberOfRounds);
        gameView = new GameView(this);
        gameView.display(userName, numberOfRounds);
        mainView.closeSettingsWindow();
    }

    public void completeOneGameRound(String symbolChosenByThePlayer) {
        gameLogic.startGame(symbolChosenByThePlayer, gameStats).forEach(this::success, this::failure);
    }

    private void failure(String errorMessage) {
        gameView.updateGameResultLabel(errorMessage);
    }

    private void success(GameLogicDto gameLogicDto) {
        gameStats = gameLogicDto.getGameStats();
        updateOfGameViewData(gameLogicDto);
        if (gameLogicDto.getGameStats().getNumberOfAvailableRounds() == 0) {
            gameView.disableSymbolsButtons();
        }
    }

    public void startNewGame() {
        boolean answer = confirmBoxView.display("Are you sure to start new game?");
        if (answer) {
            mainView.openNewSettingsWindow();
            gameView.closeGameWindow();
        }
    }

    public void closeProgram() {
        boolean answer = confirmBoxView.display("Are you sure you want to exit?");
        if (answer) {
            gameView.closeGameWindow();
        }
    }

    private void updateOfGameViewData(GameLogicDto gameLogicDto) {
        gameView.updateComputerPoint(gameLogicDto.getGameStats().getComputerPoints());
        gameView.updatePlayerPoint(gameLogicDto.getGameStats().getPlayerPoints());
        gameView.updateNumberOfAvailableRounds(gameLogicDto.getGameStats().getNumberOfAvailableRounds());
        gameView.updateGameResultLabel(gameLogicDto.getGameResult().getValue());
        gameView.updatePlayerSymbolLabel(gameLogicDto.getPlayerSymbolName().toString());
        gameView.updateComputerSymbolLabel(gameLogicDto.getComputerSymbolName().toString());
    }
}
