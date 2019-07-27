package com.kodilla.sudoku.division;

import com.kodilla.sudoku.board.element.SudokuElement;

import java.util.List;

@FunctionalInterface
public interface Group {
    List<SudokuElement> get(int row, int column);

}
