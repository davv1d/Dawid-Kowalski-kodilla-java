package com.kodilla.sudoku.model.division;

import com.kodilla.sudoku.ExampleBoard;
import com.kodilla.sudoku.model.board.SudokuBoard;
import com.kodilla.sudoku.model.board.element.SudokuElement;
import com.kodilla.sudoku.model.dto.Tuple;
import com.kodilla.sudoku.model.dto.Tuple3;
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
        Tuple3<SudokuElement, List<SudokuElement>, SudokuBoard> tuple = BoardDivider.column.apply(new Tuple<>(element, board.getBoard()));
        //When
        Tuple3<SudokuElement, Set<Integer>, SudokuBoard> result = ValuePicker.usedValues.apply(tuple);
        //Then
        Assert.assertEquals(8, result._2.size());
        System.out.println(result);
    }

    @Test
    public void testGetPossibleValues() {
        //Given
        ExampleBoard board = new ExampleBoard();
        SudokuElement element = board.getBoard().getSudokuRows().get(0).getElements().get(0);
        Tuple3<SudokuElement, List<SudokuElement>, SudokuBoard> tuple = BoardDivider.row.apply(new Tuple<>(element, board.getBoard()));
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
        Tuple3<SudokuElement, Set<Integer>, SudokuBoard> result = ValuePicker.allUsedValues.apply(new Tuple<>(element, board.getBoard()));
        //Then
        System.out.println(result._2);
    }
}
