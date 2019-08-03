package com.kodilla.sudoku.board.element;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private final List<SudokuElement> elements;

    public SudokuRow(List<SudokuElement> elements) {
        this.elements = elements;
    }

    public List<SudokuElement> getElements() {
        return elements;
    }

    @Override
    public String toString() {
        return elements.toString() + "\n";
    }

    public SudokuRow deepCopy() {
        List<SudokuElement> copyElement = new ArrayList<>();
        for (SudokuElement element : elements) {
            copyElement.add(element.deepClone());
        }
        return new SudokuRow(copyElement);
    }
}
