package com.kodilla.sudoku.board.element;

import java.util.List;

public class SudokuRow {
    private final List<SudokuElement> elements;

    public SudokuRow(List<SudokuElement> elements) {
        this.elements = elements;
    }

    public List<SudokuElement> getElements() {
        return elements;
    }
}
