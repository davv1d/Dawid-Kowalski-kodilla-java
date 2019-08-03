package com.kodilla.sudoku.board.element;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SudokuRowTestSuite {
    @Test
    public void testCreateSudokuRow() {
        //Given
        List<SudokuElement> elements = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            elements.add(new SudokuElement(i, new Position(0,i)));
        }
        //When
        SudokuRow sudokuRow = new SudokuRow(elements);
        //Then
        Assert.assertEquals(elements, sudokuRow.getElements());
    }
}
