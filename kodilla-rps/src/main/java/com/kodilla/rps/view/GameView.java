package com.kodilla.rps.view;

import com.kodilla.rps.controller.Controller;
import com.kodilla.rps.logic.symbol.SymbolName;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameView {
    private Controller controller;
    private Label playerPoint = new Label("0");
    private Label computerPoint = new Label("0");
    private Label numberOfRoundsLabel = new Label("0");
    private List<Button> symbolsButtons;
    private Label playerSymbolLabel = new Label();
    private Label computerSymbolLabel = new Label();
    private Label gameResultLabel = new Label();
    private Stage window;

    public GameView(Controller controller) {
        this.controller = controller;
    }

    public void display(String username, int numberOfRounds) {
        window = new Stage();
        window.setTitle("RPSLS GAME");
        window.setOnCloseRequest(e->{
            e.consume();
            controller.closeProgram();
        });
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(createTopMenu());
        borderPane.setBottom(createBottomMenu(numberOfRounds));
        borderPane.setLeft(createSideMenu(username, playerPoint, playerSymbolLabel));
        borderPane.setRight(createSideMenu("Computer", computerPoint, computerSymbolLabel));
        borderPane.setCenter(createCenterMenu());
        Scene scene = new Scene(borderPane, 500,500);
        window.setScene(scene);
        window.show();
    }

    private HBox createCenterMenu() {
        HBox centerMenu = new HBox();
        centerMenu.setAlignment(Pos.CENTER);
        centerMenu.setPadding(new Insets(10,10,10,10));
        centerMenu.getChildren().addAll(gameResultLabel);
        return centerMenu;
    }

    private VBox createSideMenu(String playerName, Label point, Label move) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        Label userNameLabel = new Label(playerName);
        userNameLabel.setMinWidth(100);
        userNameLabel.setAlignment(Pos.CENTER);
        GridPane.setConstraints(userNameLabel, 0,0);
        GridPane.setHalignment(userNameLabel, HPos.CENTER);
        GridPane.setConstraints(point, 0,1);
        GridPane.setHalignment(point, HPos.CENTER);
        GridPane.setConstraints(move,0,2);
        GridPane.setHalignment(move, HPos.CENTER);
        grid.getChildren().addAll(userNameLabel, point, move);
        VBox leftMenu = new VBox();
        leftMenu.getChildren().add(grid);
        return leftMenu;
    }

    private HBox createBottomMenu(int numberOfRounds) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        Label descRoundLabel = new Label("Number of round to the end:  ");
        descRoundLabel.setAlignment(Pos.BOTTOM_LEFT);
        GridPane.setConstraints(descRoundLabel, 0,0);
        numberOfRoundsLabel.setText(Integer.toString(numberOfRounds));
        GridPane.setConstraints(numberOfRoundsLabel, 1,0);
        Button newGameButton = new Button("New Game");
        newGameButton.setAlignment(Pos.BASELINE_RIGHT);
        newGameButton.setOnAction(e -> controller.startNewGame());
        GridPane.setConstraints(newGameButton, 15, 0);
        grid.getChildren().addAll(descRoundLabel, numberOfRoundsLabel, newGameButton);
        HBox bottomMenu = new HBox();
        bottomMenu.getChildren().addAll(grid);
        return bottomMenu;
    }

    private  HBox createTopMenu() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        Label descGameLabel = new Label("Choose your move");
        GridPane.setConstraints(descGameLabel, 0,0);
        GridPane.setColumnSpan(descGameLabel, 3);
        grid.getChildren().add(descGameLabel);
        symbolsButtons = createButtonsToTopMenu();
        grid.getChildren().addAll(symbolsButtons);
        HBox topMenu = new HBox();
        topMenu.getChildren().addAll(grid);
        return topMenu;
    }

    private List<Button> createButtonsToTopMenu() {
        List<String> buttonNames = Arrays.asList(
                SymbolName.ROCK.toString(),
                SymbolName.PAPER.toString(),
                SymbolName.SCISSORS.toString(),
                SymbolName.LIZARD.toString(),
                SymbolName.SPOCK.toString());
        List<Button> buttons = new ArrayList<>();
        for (int i = 0; i < buttonNames.size(); i++) {
            Button button = new Button(buttonNames.get(i));
            button.setOnAction(this::clickChosenSymbol);
            button.setPrefSize(70,20);
            GridPane.setConstraints(button, i, 1);
            buttons.add(button);
        }
        return buttons;
    }

    public void closeGameWindow() {
        window.close();
    }

    public void disableSymbolsButtons() {
        for (Button button : symbolsButtons) {
            button.setDisable(true);
        }
    }

    private void clickChosenSymbol(ActionEvent actionEvent) {
        Button source = (Button) actionEvent.getSource();
        controller.completeOneGameRound(source.getText());
    }

    public void updatePlayerPoint(int point) {
        this.playerPoint.setText(Integer.toString(point));
    }

    public void updateComputerPoint(int point) {
        this.computerPoint.setText(Integer.toString(point));
    }

    public void updateNumberOfAvailableRounds(int number) {
        this.numberOfRoundsLabel.setText(Integer.toString(number));
    }

    public void updateGameResultLabel(String result) {
        gameResultLabel.setText(result);
    }

    public void updatePlayerSymbolLabel(String playerSymbol) {
        playerSymbolLabel.setText(playerSymbol);
    }
    public void updateComputerSymbolLabel(String computerSymbol) {
        computerSymbolLabel.setText(computerSymbol);
    }
}
