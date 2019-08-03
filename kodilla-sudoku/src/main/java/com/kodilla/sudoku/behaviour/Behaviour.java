package com.kodilla.sudoku.behaviour;

import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.dto.Tuple3;
import com.kodilla.sudoku.error.MyError;

import java.util.Optional;

@FunctionalInterface
public interface Behaviour<T> {
    Tuple3<SudokuElement, Boolean, Optional<MyError>> apply(T value);
}
