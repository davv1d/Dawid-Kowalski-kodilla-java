package com.kodilla.sudoku;

import com.kodilla.sudoku.model.board.SudokuBoard;
import com.kodilla.sudoku.model.dto.Tuple;
import com.kodilla.sudoku.model.processor.Processor;
import com.kodilla.sudoku.view.View;

public class Game {
    public static void startGame() {
        while (true) {
            Tuple<SudokuBoard, String> tuple = View.writeMenu();
            if (tuple._2.equals("e")) {
                System.exit(0);
            } else {
                Processor.start(tuple._1).effect(System.out::println);
            }
        }
    }
}
