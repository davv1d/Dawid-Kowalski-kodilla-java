package com.kodilla.sudoku.division;

import com.kodilla.sudoku.ExampleBoard;
import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.division.new_division.NewBoardDivider;
import com.kodilla.sudoku.dto.Tuple;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class ValuePickerTestSuite {
    @Test
    public void testGetUsedValues() {
        //Given
        ExampleBoard board = new ExampleBoard();
        SudokuElement element = board.getBoard().getSudokuRows().get(0).getElements().get(4);
        Tuple<SudokuElement, List<SudokuElement>> tuple = NewBoardDivider.column.apply(new Tuple<>(element, board.getBoard()));
        //When
        Tuple<SudokuElement, Set<Integer>> result = ValuePicker.usedValues.apply(new Tuple<>(element, tuple._2));
        //Then
        Assert.assertEquals(8, result._2.size());
        System.out.println(result);
    }

    @Test
    public void testGetPossibleValues() {
        //Given
        ExampleBoard board = new ExampleBoard();
        SudokuElement element = board.getBoard().getSudokuRows().get(0).getElements().get(3);
        Tuple<SudokuElement, List<SudokuElement>> tuple = NewBoardDivider.column.apply(new Tuple<>(element, board.getBoard()));
        //When
        Tuple<SudokuElement, Set<Integer>> result = ValuePicker.possibleValues.apply(tuple);
        //Then
        System.out.println(result._2);
    }

    @Test
    public void testAllUsedValues() {
        //Given
        ExampleBoard board = new ExampleBoard();
        SudokuElement element = board.getBoard().getSudokuRows().get(0).getElements().get(0);
        //When
        Tuple<SudokuElement, Set<Integer>> result = ValuePicker.allUsedValues.apply(new Tuple<>(element, board.getBoard()));
        //Then
        System.out.println(result._2);
    }
}
