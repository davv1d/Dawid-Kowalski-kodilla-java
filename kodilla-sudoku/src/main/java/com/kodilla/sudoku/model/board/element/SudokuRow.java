package com.kodilla.sudoku.model.board.element;

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
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < elements.size(); i++) {
            if (i == 3 || i == 6) {
                stringBuffer.append("||  ");
            } else {
                stringBuffer.append("|  ");
            }
            stringBuffer.append(elements.get(i).toString());
            stringBuffer.append("  ");
        }
        return stringBuffer.append("|\n").toString();
    }

    public SudokuRow deepCopy() {
        List<SudokuElement> copyElement = new ArrayList<>();
        for (SudokuElement element : elements) {
            copyElement.add(element.deepClone());
        }
        return new SudokuRow(copyElement);
    }
}
