package com.kodilla.sudoku;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.element.Position;
import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.board.element.SudokuRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleBoard {
    private int e = SudokuElement.EMPTY;

    public SudokuBoard getBoard() {
        List<List<Integer>> values = getValues();
        List<SudokuRow> rows = new ArrayList<>();
        for (int row = 0; row < values.size(); row++) {
            rows.add(new SudokuRow(createRow(values.get(row), row)));
        }
        return new SudokuBoard(rows);
    }

    private List<SudokuElement> createRow(List<Integer> values, int row) {
        List<SudokuElement> elements = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            elements.add(new SudokuElement(values.get(i), new Position(row, i)));
        }
        return elements;
    }

    private List<List<Integer>> getValues() {
        List<List<Integer>> values = new ArrayList<>();
//        values.add(Arrays.asList(e, 4, e,    e, e, e,    8, 6, 5));
//        values.add(Arrays.asList(6, e, e,    5, 8, e,    3, e, e));
//        values.add(Arrays.asList(3, 5, e,    7, 4, e,    e, 2, e));
//
//        values.add(Arrays.asList(e, e, 5,    8, 1, e,    2, e, e));
//        values.add(Arrays.asList(e, 7, e,    3, 9, e,    5, 8, e));
//        values.add(Arrays.asList(9, 8, 1,    e, 6, e,    7, e, 3));
//
//        values.add(Arrays.asList(e, e, e,    4, 7, e,    e, 5, e));
//        values.add(Arrays.asList(e, e, 7,    e, 5, e,    e, e, 2));
//        values.add(Arrays.asList(e, 2, 4,    6, 3, e,    e, e, e));

        //medium
//        values.add(Arrays.asList(6, e, e,    3, e, e,    e, e, 8));
//        values.add(Arrays.asList(e, 4, e,    e, e, e,    e, e, e));
//        values.add(Arrays.asList(e, e, 8,    9, 6, 2,    e, e, e));
//
//        values.add(Arrays.asList(e, 8, e,    4, 9, 6,    e, e, 7));
//        values.add(Arrays.asList(e, 7, 5,    2, 1, e,    3, 9, e));
//        values.add(Arrays.asList(e, e, 6,    7, 5, e,    e, e, e));
//
//        values.add(Arrays.asList(8, 9, e,    e, 3, 1,    6, e, e));
//        values.add(Arrays.asList(e, e, e,    e, e, e,    e, e, 1));
//        values.add(Arrays.asList(e, e, e,    e, e, e,    e, 4, 9));

        //difficult
        values.add(Arrays.asList(8, e, e,    e, e, 9,    e, e, 5));
        values.add(Arrays.asList(e, 4, e,    e, e, e,    7, 2, 6));
        values.add(Arrays.asList(e, e, e,    e, 3, e,    8, e, e));

        values.add(Arrays.asList(e, e, e,    e, 4, 7,    e, e, e));
        values.add(Arrays.asList(e, 3, e,    e, 5, e,    e, e, e));
        values.add(Arrays.asList(e, e, 4,    e, 9, e,    5, 3, e));

        values.add(Arrays.asList(e, e, e,    e, 7, e,    e, e, e));
        values.add(Arrays.asList(9, 1, e,    e, 2, e,    e, 8, e));
        values.add(Arrays.asList(e, 2, e,    e, e, 5,    9, e, e));

        //expert
//        values.add(Arrays.asList(9, e, e,    e, e, 8,    4, e, e));
//        values.add(Arrays.asList(e, e, 5,    9, e, 3,    e, e, 6));
//        values.add(Arrays.asList(4, e, e,    e, e, e,    e, e, e));
//
//        values.add(Arrays.asList(e, e, e,    e, e, 6,    e, 2, e));
//        values.add(Arrays.asList(e, e, e,    e, 1, 9,    e, e, 7));
//        values.add(Arrays.asList(e, 8, e,    e, e, e,    1, e, e));
//
//        values.add(Arrays.asList(6, e, 8,    e, e, 1,    e, e, 9));
//        values.add(Arrays.asList(e, e, 3,    e, e, e,    e, e, e));
//        values.add(Arrays.asList(2, e, e,    4, e, e,    e, 5, e));

        return values;
    }
}
