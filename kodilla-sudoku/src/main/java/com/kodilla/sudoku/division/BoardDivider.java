package com.kodilla.sudoku.division;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.element.SudokuElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BoardDivider {
    private SudokuBoard board;

    public BoardDivider(SudokuBoard board) {
        this.board = board;
    }

    public final Group row = (row, column) -> board.getSudokuRows().get(row).getElements();

    public final Group column = (row, column) ->
            board.getSudokuRows().stream()
                    .map(sudokuRow -> sudokuRow.getElements().get(column))
                    .collect(Collectors.toList());

    public final Group sector = (row, column) ->
    {
        List<SudokuElement> elements = new ArrayList<>();
        for (Integer secRow : Sectors.get(row)) {
            for (Integer secCol : Sectors.get(column)) {
                elements.add(board.getSudokuRows().get(secRow).getElements().get(secCol));
            }
        }
        return elements;
    };
}
