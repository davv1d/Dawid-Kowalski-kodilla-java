package com.kodilla.sudoku.mcase;

import com.kodilla.sudoku.ExampleBoard;
import com.kodilla.sudoku.board.element.Position;
import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.division.new_division.BoardDivider;
import com.kodilla.sudoku.dto.Tuple;
import com.kodilla.sudoku.dto.Tuple3;
import com.kodilla.sudoku.result.ValidResult;
import com.kodilla.sudoku.validate.Validator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class CaseTestSuite {
    @Test
    public void testCaseFinish() {
        //Given
        SudokuElement element = new SudokuElement(5, new Position(1, 1));
        ValidResult error = ValidResult.error(new Tuple<>(element, true));
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
        Case nextCase = Case.nextCase(new Tuple3<>(element, board.getBoard(), true));
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
        Case nextCase = Case.nextCase(new Tuple3<>(element, board.getBoard(), true));
        Case finish = Case.finish(() -> true, ValidResult.error(new Tuple<>(element, true)));
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
