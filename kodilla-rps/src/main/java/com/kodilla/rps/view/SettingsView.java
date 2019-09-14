package com.kodilla.rps.view;

import com.kodilla.rps.controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SettingsView extends Application {
    private TextField nameInput;
    private Spinner<Integer> numberOfRoundsSpinner;
    private Stage window;
    private Controller controller = new Controller(this);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        defaultWindowSettings(primaryStage);
    }

    private void defaultWindowSettings(Stage primaryStage) {
        window = primaryStage;
        primaryStage.setTitle("Rock-Paper-Scissors-Lizard-Spock Settings");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label nameLabel = new Label("User name:");
        GridPane.setConstraints(nameLabel, 0, 0);

        nameInput = new TextField("John");
        GridPane.setConstraints(nameInput, 1, 0);

        Label numberOfRoundsLabel = new Label("Number of rounds:");
        GridPane.setConstraints(numberOfRoundsLabel, 0, 1);

        numberOfRoundsSpinner = new Spinner<>(0, 11, 1);
        GridPane.setConstraints(numberOfRoundsSpinner, 1, 1);

        Button buttonLogin = new Button("Play");
        buttonLogin.setOnAction(this::startNewGame);
        GridPane.setConstraints(buttonLogin, 1,2);

        grid.getChildren().addAll(nameLabel, nameInput, numberOfRoundsLabel, numberOfRoundsSpinner, buttonLogin);

        Scene scene = new Scene(grid, 420,150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void openNewSettingsWindow() {
        defaultWindowSettings(new Stage());
    }

    public void closeSettingsWindow() {
        window.close();
    }
    private void startNewGame(ActionEvent actionEvent) {
        controller.createGameView(nameInput.getText(), numberOfRoundsSpinner.getValue());
    }
}
