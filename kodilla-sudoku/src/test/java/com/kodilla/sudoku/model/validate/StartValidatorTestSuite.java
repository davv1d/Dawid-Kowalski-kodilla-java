package com.kodilla.sudoku.model.validate;

import com.kodilla.sudoku.ExampleBoard;
import com.kodilla.sudoku.model.board.SudokuBoard;
import com.kodilla.sudoku.model.result.StartResult;
import org.junit.Test;

import java.util.List;

public class StartValidatorTestSuite {
    @Test
    public void testCondition() {
        //Given
        SudokuBoard board = new ExampleBoard().getBoard();
        //When
        List<Integer> values = StartValidator.getValues.apply(board.getSudokuRows().get(0).getElements());
        System.out.println(values);
        boolean condition = StartValidator.condition.apply(values);
        System.out.println(condition);
        StartResult check = StartValidator.check(board);
        System.out.println(check);
    }
}
