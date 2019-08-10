package com.kodilla.sudoku.model.behaviour;

import com.kodilla.sudoku.model.board.element.SudokuElement;
import com.kodilla.sudoku.model.dto.Tuple;
import com.kodilla.sudoku.model.dto.Tuple3;
import com.kodilla.sudoku.model.error.MyError;
import com.kodilla.sudoku.model.move.Move;

import java.util.List;
import java.util.Optional;

public class Behaviours {

    public static Behaviour<Tuple<SudokuElement, List<Integer>>> write = value -> {
        SudokuElement element = new SudokuElement(value._2.get(0), value._1.getPosition());
        return new Tuple3<>(element, Move.yes(), Optional.empty());
    };

    public static Behaviour<Tuple<SudokuElement, Move>> error = value ->
            new Tuple3<>(value._1, value._2, Optional.of(new MyError("The value I have to enter is already used. Error in row: " +
                    value._1.getPosition().getRow() +
                    " col: " +
                    value._1.getPosition().getColumn())));

}
