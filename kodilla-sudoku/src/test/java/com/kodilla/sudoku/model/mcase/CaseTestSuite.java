package com.kodilla.sudoku.model.mcase;

import com.kodilla.sudoku.ExampleBoard;
import com.kodilla.sudoku.model.board.element.Position;
import com.kodilla.sudoku.model.board.element.SudokuElement;
import com.kodilla.sudoku.model.division.BoardDivider;
import com.kodilla.sudoku.model.dto.Tuple;
import com.kodilla.sudoku.model.dto.Tuple3;
import com.kodilla.sudoku.model.move.Move;
import com.kodilla.sudoku.model.result.ValidResult;
import com.kodilla.sudoku.model.validate.Validator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class CaseTestSuite {
    @Test
    public void testCaseFinish() {
        //Given
        SudokuElement element = new SudokuElement(5, new Position(1, 1));
        ValidResult error = ValidResult.error(new Tuple<>(element, Move.no()));
        //When
        Case finish = Case.finish(() -> true, error);
        Case aCase = finish
                .checkNext(BoardDivider.row, Validator.checkPossibleValues)
                .checkNext(BoardDivider.sector, Validator.checkPossibleValues);

        //Then
        System.out.println(finish.get());
        Assert.assertEquals(finish, aCase);
    }

    @Test
    public void testNextCase() {
        //Given
        ExampleBoard board = new ExampleBoard();
        SudokuElement element = board.getBoard().getSudokuRows().get(0).getElements().get(0);
        //When
        Case nextCase = Case.nextCase(new Tuple3<>(element, board.getBoard(), Move.yes()));
        ValidResult validResult = nextCase.get();
        Case aCase = nextCase.checkNext(BoardDivider.row, Validator.checkPossibleValues);
        //Then
        System.out.println(nextCase.getClass());
        System.out.println(validResult);
        Assert.assertNotEquals(aCase, nextCase);
    }

    @Test
    public void testMatch() {
        //Given
        ExampleBoard board = new ExampleBoard();
        SudokuElement element = board.getBoard().getSudokuRows().get(0).getElements().get(0);
        Case nextCase = Case.nextCase(new Tuple3<>(element, board.getBoard(), Move.yes()));
        Case finish = Case.finish(() -> true, ValidResult.error(new Tuple<>(element, Move.no())));
        Case finish1 = Case.finish(() -> false, ValidResult.write(new Tuple<>(element, Collections.singletonList(5))));
        //When
        Case aCase = Case.match(nextCase, finish);
        Case aCase1 = Case.match(nextCase, finish, finish1);
        Case aCase2 = Case.match(nextCase, finish1);
        //Then
        Assert.assertEquals(finish, aCase);
        Assert.assertEquals(finish, aCase1);
        Assert.assertEquals(nextCase, aCase2);

    }
}
