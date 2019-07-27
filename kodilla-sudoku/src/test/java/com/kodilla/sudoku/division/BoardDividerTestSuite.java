package com.kodilla.sudoku.division;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.board.element.SudokuRow;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BoardDividerTestSuite {
    @Test
    public void testGetRow() {
        //Given
        int row = 1;
        int col = 2;
        SudokuBoard board = getBoard();
        BoardDivider boardDivider = new BoardDivider(board);
        //When
        List<SudokuElement> elements = boardDivider.row.get(row, col);
        //Then
        System.out.println(elements);
    }

    @Test
    public void testGetColumn() {
        //Given
        int row = 1;
        int col = 8;
        SudokuBoard board = getBoard();
        BoardDivider boardDivider = new BoardDivider(board);
        //When
        List<SudokuElement> elements = boardDivider.column.get(row, col);
        //Then
        System.out.println(elements);
    }

    @Test
    public void testGetSector() {
        //Given
        int row = 8;
        int col = 8;
        SudokuBoard board = getBoard();
        BoardDivider boardDivider = new BoardDivider(board);
        //When
        List<SudokuElement> elements = boardDivider.sector.get(row, col);
        //Then
        System.out.println(elements);
    }

    private List<SudokuElement> getElement(int value) {
        List<SudokuElement> elements = new ArrayList<>();
        for (int i = value; i < value+9; i++) {
            elements.add(new SudokuElement(i, new Position(0, i)));
        }
        return elements;
    }

    private SudokuBoard getBoard() {
        List<SudokuRow> rows = new ArrayList<>();
        for (int i = 1; i < 82; i=i+9) {
            rows.add(new SudokuRow(getElement(i)));
        }
        return new SudokuBoard(rows);
    }
}
