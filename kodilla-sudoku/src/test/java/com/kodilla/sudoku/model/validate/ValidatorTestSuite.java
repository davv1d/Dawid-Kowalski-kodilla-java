package com.kodilla.sudoku.model.validate;

import com.kodilla.sudoku.ExampleBoard;
import com.kodilla.sudoku.model.board.EmptyBoard;
import com.kodilla.sudoku.model.board.SudokuBoard;
import com.kodilla.sudoku.model.board.element.Position;
import com.kodilla.sudoku.model.board.element.SudokuElement;
import com.kodilla.sudoku.model.dto.Tuple;
import com.kodilla.sudoku.model.dto.Tuple3;
import com.kodilla.sudoku.model.dto.Tuple4;
import com.kodilla.sudoku.model.mcase.Case;
import com.kodilla.sudoku.model.move.Move;
import com.kodilla.sudoku.model.result.ValidResult;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;

public class ValidatorTestSuite {
    private SudokuBoard board = new ExampleBoard().getBoard();

    @Test
    public void testConditionUsedValues() {
        //Given
        SudokuElement element = board.getSudokuRows().get(0).getElements().get(0);
        List<Integer> possible = new ArrayList<>();
        List<Integer> possible2 = Collections.singletonList(1);
        SudokuElement error = new SudokuElement(element.getPosition(), element.getValue(), possible);
        SudokuElement write = new SudokuElement(element.getPosition(), element.getValue(), possible2);
        //When
        Case aCase = Validator.conditionUsedValues.apply(new Tuple3<>(element, Move.yes(), board));
        Case eCase = Validator.conditionUsedValues.apply(new Tuple3<>(error, Move.yes(), board));
        Case wCase = Validator.conditionUsedValues.apply(new Tuple3<>(write, Move.yes(), board));
        //Then
        System.out.println(aCase + " and " + aCase.get());
        System.out.println(eCase + " and " + eCase.get());
        System.out.println(wCase + " and " + wCase.get());
    }

    @Test
    public void testConditionsPossibleValues() {
        //Given
        SudokuElement element = board.getSudokuRows().get(0).getElements().get(0);
        List<Integer> possible = new ArrayList<>();
        List<Integer> possible2 = Collections.singletonList(1);
        //When
        Case aCase = Validator.conditionsPossibleValues.apply(new Tuple4<>(element, board, possible, Move.yes()));
        Case aCase1 = Validator.conditionsPossibleValues.apply(new Tuple4<>(element, board, possible2, Move.yes()));
        //Then
        System.out.println(aCase);
        System.out.println(aCase1);
    }

    @Test
    public void testFindValueInPossibleValues() {
        //Given
        SudokuElement element = new SudokuElement(new Position(1, 1), SudokuElement.EMPTY, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 5, 6, 7, 8));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3,4, 5, 6, 7, 8,9));
        //When
        List<Integer> result = Validator.findValueInPossibleValues.apply(new Tuple<>(element, set));
        List<Integer> result2 = Validator.findValueInPossibleValues.apply(new Tuple<>(element, set2));
        //Then
        Assert.assertEquals(1, result.size());
        Assert.assertTrue(result.contains(4));
        Assert.assertTrue(result2.isEmpty());
    }

    @Test
    public void testCheckIfNotEmpty() {
        //Given
        SudokuElement element = board.getSudokuRows().get(2).getElements().get(4);
        EmptyBoard emptyBoard = new EmptyBoard();
        SudokuBoard board = emptyBoard.getBoard();
        SudokuElement element1 = board.getSudokuRows().get(0).getElements().get(0);
        //When
        ValidResult validResult = Validator.checkIfNotEmpty.apply(new Tuple<>(element1, board));
        //Then
        System.out.println(validResult);
    }

    @Test
    public void testCheck() {
        //Given
        Integer i = SudokuElement.EMPTY;
        Integer j = 6;
        //When
        Function<Tuple<SudokuElement, SudokuBoard>, ValidResult> notValue = Validator.check.apply(i);
        Function<Tuple<SudokuElement, SudokuBoard>, ValidResult> isValue = Validator.check.apply(j);
        //Then
        Assert.assertEquals(Validator.checkIfNotEmpty, notValue);
        Assert.assertNotEquals(Validator.checkIfNotEmpty, isValue);
    }
}
