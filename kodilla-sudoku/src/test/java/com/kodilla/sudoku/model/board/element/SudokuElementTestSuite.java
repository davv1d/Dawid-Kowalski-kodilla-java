package com.kodilla.sudoku.model.board.element;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SudokuElementTestSuite {
    @Test
    public void testCreateEmptySudokuElement() {
        //Given
        SudokuElement sudokuElement = new SudokuElement(SudokuElement.EMPTY, new Position(0,0));
        List<Integer> possibleValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //When
        int value = sudokuElement.getValue();
        List<Integer> resultValues = sudokuElement.getPossibleValues();
        //Then
        Assert.assertEquals(-1, value);
        Assert.assertEquals(possibleValues, resultValues);
    }

    @Test
    public void testCreateSudokuElementWithValue() {
        //Given
        //When
        SudokuElement sudokuElement = new SudokuElement(7, new Position(0,0));
        //Then
        Assert.assertEquals(7, sudokuElement.getValue());
        Assert.assertEquals(8, sudokuElement.getPossibleValues().size());
        Assert.assertFalse(sudokuElement.getPossibleValues().contains(7));;
    }
}
