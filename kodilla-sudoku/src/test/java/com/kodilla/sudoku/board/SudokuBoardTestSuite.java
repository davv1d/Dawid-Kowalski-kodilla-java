package com.kodilla.sudoku.board;

import com.kodilla.sudoku.board.element.Position;
import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.board.element.SudokuRow;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoardTestSuite {
    @Test
    public void testCreateSudokuBoard() {
        //Given
        List<SudokuRow> sudokuRows = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            List<SudokuElement> elements = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                elements.add(new SudokuElement(j, new Position(i,j)));
            }
            sudokuRows.add(new SudokuRow(elements));
        }
        //When
        SudokuBoard sudokuBoard = new SudokuBoard(sudokuRows);
        //Then
        Assert.assertEquals(2, sudokuBoard.getSudokuRows().size());
        Assert.assertEquals(9, sudokuBoard.getSudokuRows().get(0).getElements().size());
    }
}
