package com.kodilla.sudoku.model.board;

import com.kodilla.sudoku.model.board.element.Position;
import com.kodilla.sudoku.model.board.element.SudokuElement;
import com.kodilla.sudoku.model.board.element.SudokuRow;

import java.util.ArrayList;
import java.util.List;

public class EmptyBoard {

    public SudokuBoard getBoard() {
        List<SudokuRow> rows = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            rows.add(new SudokuRow(createRow(row)));
        }
        return new SudokuBoard(rows);
    }


    private List<SudokuElement> createRow(int row) {
        List<SudokuElement> elements = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            elements.add(new SudokuElement(SudokuElement.EMPTY, new Position(row, i)));
        }
        return elements;
    }
}
