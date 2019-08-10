package com.kodilla.sudoku.model.behaviour;

import com.kodilla.sudoku.model.board.element.SudokuElement;
import com.kodilla.sudoku.model.dto.Tuple3;
import com.kodilla.sudoku.model.error.MyError;
import com.kodilla.sudoku.model.move.Move;

import java.util.Optional;

@FunctionalInterface
public interface Behaviour<T> {
    Tuple3<SudokuElement, Move, Optional<MyError>> apply(T value);
}
