package com.kodilla.sudoku.validate;

import com.kodilla.sudoku.ExampleBoard;
import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.dto.Tuple;
import com.kodilla.sudoku.effect.Effect;
import com.kodilla.sudoku.effect.EffectRemove;
import org.junit.Assert;
import org.junit.Test;

public class ValidatorTestSuite {

    @Test
    public void testEffect() {
        //Given
        ExampleBoard board = new ExampleBoard();
        SudokuElement element = board.getBoard().getSudokuRows().get(0).getElements().get(0);
        //When
        Effect result = Validator.test(new Tuple<>(element, board.getBoard()));
        //Then
        Assert.assertEquals(EffectRemove.class, result.getClass());
    }
}
