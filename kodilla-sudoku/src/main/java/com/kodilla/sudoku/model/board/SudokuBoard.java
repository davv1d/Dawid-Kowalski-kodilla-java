package com.kodilla.sudoku.model.board;

import com.kodilla.sudoku.model.board.element.SudokuElement;
import com.kodilla.sudoku.model.board.element.SudokuRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class SudokuBoard {
    private final List<SudokuRow> sudokuRows;

    public SudokuBoard(List<SudokuRow> sudokuRows) {
        this.sudokuRows = sudokuRows;
    }

    public List<SudokuRow> getSudokuRows() {
        return sudokuRows;
    }

    public SudokuBoard deepCopy() {
        List<SudokuRow> copyRows = new ArrayList<>();
        for (SudokuRow sudokuRow : sudokuRows) {
            copyRows.add(sudokuRow.deepCopy());
        }
        return new SudokuBoard(copyRows);
    }

    public boolean isFull() {
        return sudokuRows.stream()
                .flatMap(sudokuRow -> sudokuRow.getElements().stream())
                .noneMatch(element -> element.getValue() == SudokuElement.EMPTY);
    }

    public Optional<SudokuElement> findElementWithTheFewestPossibleValues() {
        return sudokuRows.stream()
                .flatMap(sudokuRow -> sudokuRow.getElements().stream())
                .filter(element -> element.getValue() == SudokuElement.EMPTY)
                .reduce((element, element2) -> element = element.getPossibleValues().size() > element2.getPossibleValues().size() ? element2 : element);
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder("|-----|-----|-----||-----|-----|-----||-----|-----|-----|\n");
        for (int i = 0; i < sudokuRows.size(); i++) {
            stringBuffer.append(sudokuRows.get(i).toString());
            if(i == 2 || i == 5) {
                stringBuffer.append("|=====|=====|=====||=====|=====|=====||=====|=====|=====|\n");
            } else {
                stringBuffer.append("|-----|-----|-----||-----|-----|-----||-----|-----|-----|\n");
            }
        }
        return stringBuffer.append("\n").toString();
    }
}
