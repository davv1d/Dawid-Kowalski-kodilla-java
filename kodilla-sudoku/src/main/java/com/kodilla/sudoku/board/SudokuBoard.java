package com.kodilla.sudoku.board;

import com.kodilla.sudoku.board.element.SudokuRow;

import java.util.List;

public class SudokuBoard {
    private final List<SudokuRow> sudokuRows;

    public SudokuBoard(List<SudokuRow> sudokuRows) {
        this.sudokuRows = sudokuRows;
    }

    public List<SudokuRow> getSudokuRows() {
        return sudokuRows;
    }
}
