package com.kodilla.sudoku.division.new_division;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.dto.Tuple;
import com.kodilla.sudoku.dto.Tuple3;

import java.util.List;
import java.util.function.Function;

@FunctionalInterface
public interface Group extends Function<Tuple<SudokuElement, SudokuBoard>, Tuple3<SudokuElement, List<SudokuElement>, SudokuBoard>> {

}
