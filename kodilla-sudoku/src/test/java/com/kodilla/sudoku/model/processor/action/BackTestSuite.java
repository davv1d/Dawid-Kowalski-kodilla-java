package com.kodilla.sudoku.model.processor.action;

import com.kodilla.sudoku.ExampleBoard;
import com.kodilla.sudoku.model.board.SudokuBoard;
import com.kodilla.sudoku.model.board.element.Position;
import com.kodilla.sudoku.model.board.element.SudokuElement;
import com.kodilla.sudoku.model.dto.Tuple3;
import com.kodilla.sudoku.model.dto.backtrack.Backtrack;
import com.kodilla.sudoku.model.result.ProcessorResult;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class BackTestSuite {
    @Test
    public void testBack() {
        //Given
        SudokuBoard board = new ExampleBoard().getBoard();
        SudokuBoard sudokuBoard = board.deepCopy();
        int value = sudokuBoard.getSudokuRows().get(0).getElements().get(0).getValue();
        sudokuBoard.getSudokuRows().get(0).getElements().set(0, new SudokuElement(5, new Position(0,0)));
        Backtrack backtrack = new Backtrack(board, new Position(0,0), 5);
        //When
        ProcessorResult result = Back.apply(new Tuple3<>(sudokuBoard, Optional.empty(), Optional.of(backtrack)));
        SudokuElement element1 = result.getBoard().getSudokuRows().get(0).getElements().get(0);
        //Then
        Assert.assertEquals(value, element1.getValue());
        Assert.assertNotEquals(5, element1.getValue());
        Assert.assertNotEquals(board, result.getBoard());
        Assert.assertFalse(result.isEnd());
    }
}
