package com.kodilla.sudoku.board;

import com.kodilla.sudoku.board.element.SudokuRow;

import java.util.ArrayList;
import java.util.List;

public final class SudokuBoard {
    private final List<SudokuRow> sudokuRows;

    public SudokuBoard(List<SudokuRow> sudokuRows) {
        this.sudokuRows = sudokuRows;
    }

    public List<SudokuRow> getSudokuRows() {
        return sudokuRows;
    }

    @Override
    public String toString() {
        return "SudokuBoard \n" +
                sudokuRows;
    }

    public SudokuBoard deepCopy() {
        List<SudokuRow> copyRows = new ArrayList<>();
        for (SudokuRow sudokuRow : sudokuRows) {
            copyRows.add(sudokuRow.deepCopy());
        }
        return new SudokuBoard(copyRows);
    }
}
