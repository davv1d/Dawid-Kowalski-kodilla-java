package com.kodilla.sudoku.model.board;

import com.kodilla.sudoku.ExampleBoard;
import com.kodilla.sudoku.model.board.element.Position;
import com.kodilla.sudoku.model.board.element.SudokuElement;
import com.kodilla.sudoku.model.board.element.SudokuRow;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    @Test
    public void testIsFull() {
        //Given
        SudokuBoard board = new ExampleBoard().getBoard();
        //When
        boolean result1 = board.isFull();
        //Then
        Assert.assertFalse(result1);
    }

    @Test
    public void testFindElementWithTheFewestPossibleValues() {
        //Given
        SudokuBoard board = new EmptyBoard().getBoard();
        SudokuElement sudokuElement = new SudokuElement(new Position(0, 0), Arrays.asList(1, 2, 3));
        board.getSudokuRows().get(0).getElements().set(0, sudokuElement);
        //When
        Optional<SudokuElement> result = board.findElementWithTheFewestPossibleValues();
        //Then
        Assert.assertTrue(result.isPresent());
        Assert.assertEquals(3, result.get().getPossibleValues().size());
    }
}
