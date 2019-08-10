package com.kodilla.sudoku.model.behaviour;

import com.kodilla.sudoku.model.board.element.Position;
import com.kodilla.sudoku.model.board.element.SudokuElement;
import com.kodilla.sudoku.model.dto.Tuple;
import com.kodilla.sudoku.model.dto.Tuple3;
import com.kodilla.sudoku.model.error.MyError;
import com.kodilla.sudoku.model.move.Move;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BehavioursTestSuite {
    @Test
    public void testWrite() {
        //Given
        SudokuElement sudokuElement = new SudokuElement(new Position(0, 0));
        List<Integer> values = Collections.singletonList(5);
        //When
        Tuple3<SudokuElement, Move, Optional<MyError>> result = Behaviours.write.apply(new Tuple<>(sudokuElement, values));
        //Then
        Assert.assertFalse(result._3.isPresent());
        Assert.assertTrue(result._2.is());
        Assert.assertEquals(5, result._1.getValue());
    }

    @Test
    public void testError() {
        //Given
        SudokuElement element = new SudokuElement(new Position(0,0));
        Move move = Move.no();
        Tuple<SudokuElement, Move> tuple = new Tuple<>(element, move);
        //When
        Tuple3<SudokuElement, Move, Optional<MyError>> result = Behaviours.error.apply(tuple);
        //Then
        Assert.assertEquals(element, result._1);
        Assert.assertEquals(move.is(), result._2.is());
        Assert.assertTrue(result._3.isPresent());
    }
}
