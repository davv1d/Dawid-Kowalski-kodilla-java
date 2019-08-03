package com.kodilla.sudoku.processor;

import com.kodilla.sudoku.behaviour.Behaviours;
import com.kodilla.sudoku.board.EmptyBoard;
import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.dto.Tuple;
import com.kodilla.sudoku.dto.Tuple3;
import com.kodilla.sudoku.error.MyError;
import com.kodilla.sudoku.validate.Validator;

import java.util.Optional;

public class Processor {
    private static EmptyBoard emptyBoard = new EmptyBoard();

    public static SudokuBoard proc(final SudokuBoard board) {
        SudokuBoard copyBoard = board.deepCopy();
        SudokuBoard empty = emptyBoard.getBoard();
        Boolean move;
        do {
            move = false;
            for (int i = 0; i < copyBoard.getSudokuRows().size(); i++) {
                for (int j = 0; j < copyBoard.getSudokuRows().get(i).getElements().size(); j++) {
                    SudokuElement element = copyBoard.getSudokuRows().get(i).getElements().get(j);
                    Tuple3<SudokuElement, Boolean, Optional<MyError>> execute = Validator.check.apply(element.getValue()).apply(new Tuple<>(element, copyBoard)).execute(Behaviours.write, Behaviours.error);
                    if (execute._3.isPresent()) {
                        System.out.println(execute._3.get().getMessage());
                        return empty;
                    } else {
                        move = move || execute._2;
                        empty.getSudokuRows().get(i).getElements().set(j, execute._1);
                    }
                }
            }
            copyBoard = empty;
        } while (move);
        return empty;
    }
}
