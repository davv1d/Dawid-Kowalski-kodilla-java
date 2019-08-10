package com.kodilla.sudoku.model.processor.action;

import com.kodilla.sudoku.ExampleBoard;
import com.kodilla.sudoku.model.board.SudokuBoard;
import com.kodilla.sudoku.model.dto.Tuple3;
import com.kodilla.sudoku.model.dto.backtrack.Backtrack;
import com.kodilla.sudoku.model.error.MyError;
import com.kodilla.sudoku.model.result.ProcessorResult;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class ShotTestSuite {
    @Test
    public void testShot() {
        //Given
        SudokuBoard board = new ExampleBoard().getBoard();
        Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>> tuple3 = new Tuple3<>(board, Optional.empty(), Optional.empty());
        //When
        ProcessorResult result = Shot.apply(tuple3);
        //Then
        Assert.assertTrue(result.getBacktrack().isPresent());
        Assert.assertNotEquals(board,result.getBoard());
        System.out.println(result);
    }
}
