package com.kodilla.sudoku.behaviour;

import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.dto.Tuple;
import com.kodilla.sudoku.dto.Tuple3;
import com.kodilla.sudoku.error.MyError;

import java.util.List;
import java.util.Optional;

public class Behaviours {

    public static Behaviour<Tuple<SudokuElement, List<Integer>>> write = value -> {
        SudokuElement element = new SudokuElement(value._2.get(0), value._1.getPosition());
        return new Tuple3<>(element, true, Optional.empty());
    };

    public static Behaviour<Tuple<SudokuElement, Boolean>> error = value ->
            new Tuple3<>(value._1, value._2, Optional.of(new MyError("Error in row: " +
                    value._1.getPosition().getRow() +
                    " col: " +
                    value._1.getPosition().getColumn())));
}
