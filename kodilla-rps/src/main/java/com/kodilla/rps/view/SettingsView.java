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
    private Spinner<Integer> numberSpinner;
    private Stage window;
    private Controller controller = new Controller(this);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        test(primaryStage);
    }

    private void test(Stage primaryStage) {
        window = primaryStage;
        primaryStage.setTitle("Rock-Paper-Scissors-Lizard-Spock Settings");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //name label
        Label nameLabel = new Label("User name:");
        GridPane.setConstraints(nameLabel, 0, 0);

        //name input
        nameInput = new TextField("John");
        GridPane.setConstraints(nameInput, 1, 0);

        //number of rounds label
        Label numberOfRoundsLabel = new Label("Number of rounds:");
        GridPane.setConstraints(numberOfRoundsLabel, 0, 1);

        //number of rounds Spinner
        numberSpinner = new Spinner<>(0, 11, 1);
        GridPane.setConstraints(numberSpinner, 1, 1);

        Button buttonLogin = new Button("Play");
        buttonLogin.setOnAction(this::clickPlay);
        GridPane.setConstraints(buttonLogin, 1,2);

        grid.getChildren().addAll(nameLabel, nameInput, numberOfRoundsLabel, numberSpinner, buttonLogin);

        Scene scene = new Scene(grid, 420,150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void testCreate() {
        test(new Stage());
    }

    public void closeWindow() {
        window.close();
    }
    private void clickPlay(ActionEvent actionEvent) {
        controller.startGame(nameInput.getText(), numberSpinner.getValue());
    }
}
