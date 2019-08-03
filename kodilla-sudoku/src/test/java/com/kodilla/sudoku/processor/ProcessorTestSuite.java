package com.kodilla.sudoku.processor;

import com.kodilla.sudoku.ExampleBoard;
import com.kodilla.sudoku.board.SudokuBoard;
import org.junit.Assert;
import org.junit.Test;

public class ProcessorTestSuite {
    @Test
    public void testProcessor() {
        //Given
        SudokuBoard board = new ExampleBoard().getBoard();
        //When
        SudokuBoard proc = Processor.proc(board);
        //Then
        System.out.println(proc);
        Assert.assertNotEquals(board, proc);

    }
}
