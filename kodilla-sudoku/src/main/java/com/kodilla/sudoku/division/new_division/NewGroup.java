package com.kodilla.sudoku.division.new_division;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.dto.Tuple;

import java.util.List;
import java.util.function.Function;

@FunctionalInterface
public interface NewGroup extends Function<Tuple<SudokuElement, SudokuBoard>, Tuple<SudokuElement, List<SudokuElement>>> {

}
