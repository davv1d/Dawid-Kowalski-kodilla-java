package com.kodilla.rps.controller;

import com.kodilla.rps.domain.GamePointStats;
import com.kodilla.rps.domain.ModelDto;
import com.kodilla.rps.model.Model;
import com.kodilla.rps.view.ConfirmBox;
import com.kodilla.rps.view.GameView;
import com.kodilla.rps.view.SettingsView;

public class Controller {
    private GameView gameView;
    private SettingsView settings;
    private GamePointStats gamePointStats;
    private Model model = new Model();
    private ConfirmBox confirmBox = new ConfirmBox();

    public Controller(SettingsView settingsGame) {
        settings = settingsGame;
    }

    public void startGame(String userName, Integer numberOfRounds) {
        gamePointStats = new GamePointStats(numberOfRounds);
        gameView = new GameView(this);
        gameView.display(userName, numberOfRounds);
        settings.closeWindow();
    }

    public void makeOneRound(String chosenElement) {
        ModelDto modelDto = model.play(chosenElement, this.gamePointStats);
        gamePointStats = modelDto.getGamePointStats();
        gameView.updateComputerPoint(modelDto.getGamePointStats().getComputerPoints());
        gameView.updatePlayerPoint(modelDto.getGamePointStats().getPlayerPoints());
        gameView.updateNumberOfRounds(modelDto.getGamePointStats().getNumberOfRounds());
        gameView.updateGameStatusLabel(modelDto.getGameStats());
        gameView.updatePlayerMoveLabel(modelDto.getPlayerSelection());
        gameView.updateComputerMoveLabel(modelDto.getComputerSelection());
        if (modelDto.getGamePointStats().getNumberOfRounds() == 0) {
            gameView.disableTopMenuButtons();
        }
    }

    public void questionAboutANewGame() {
        boolean answer = confirmBox.display("Warning", "Are you sure to start new game?");
        if (answer) {
            settings.testCreate();
            gameView.closeProgram();
        }
    }

    public void questionAboutCloseProgram() {
        boolean answer = confirmBox.display("Warning", "Are you sure you want to exit");
        if (answer) {
            gameView.closeProgram();
        }
    }
}
