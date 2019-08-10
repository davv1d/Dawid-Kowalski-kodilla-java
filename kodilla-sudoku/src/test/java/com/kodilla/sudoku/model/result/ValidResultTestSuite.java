package com.kodilla.sudoku.model.result;

import com.kodilla.sudoku.ExampleBoard;
import com.kodilla.sudoku.model.behaviour.Behaviours;
import com.kodilla.sudoku.model.board.element.Position;
import com.kodilla.sudoku.model.board.element.SudokuElement;
import com.kodilla.sudoku.model.dto.Tuple;
import com.kodilla.sudoku.model.dto.Tuple3;
import com.kodilla.sudoku.model.error.MyError;
import com.kodilla.sudoku.model.move.Move;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Optional;

public class ValidResultTestSuite {
    @Test
    public void testResultWrite() {
        //Given
        SudokuElement element = new SudokuElement(new Position(1,1), SudokuElement.EMPTY, Collections.singletonList(5));
        //When
        ValidResult write = ValidResult.write(new Tuple<>(element, Collections.singletonList(5)));
        Tuple3<SudokuElement, Move, Optional<MyError>> execute = write.execute(Behaviours.write, Behaviours.error);
        //Then
        Assert.assertTrue(execute._2.is());
        Assert.assertFalse(execute._3.isPresent());
        System.out.println(execute._1);
        Assert.assertEquals(5, execute._1.getValue());
    }

    @Test
    public void testEmptyResult() {
        //Given
        ExampleBoard board = new ExampleBoard();
        SudokuElement element = board.getBoard().getSudokuRows().get(0).getElements().get(0);
        //When
        ValidResult empty = ValidResult.onlyMove(new Tuple<>(element, Move.yes()));
        Tuple3<SudokuElement, Move, Optional<MyError>> execute = empty.execute(Behaviours.write, Behaviours.error);
        //Then
        Assert.assertEquals(element, execute._1);
        Assert.assertTrue(execute._2.is());
        Assert.assertFalse(execute._3.isPresent());
    }
}
