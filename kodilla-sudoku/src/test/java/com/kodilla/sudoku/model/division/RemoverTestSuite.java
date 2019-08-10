package com.kodilla.sudoku.model.division;

import com.kodilla.sudoku.ExampleBoard;
import com.kodilla.sudoku.model.board.SudokuBoard;
import com.kodilla.sudoku.model.board.element.SudokuElement;
import com.kodilla.sudoku.model.dto.Tuple3;
import com.kodilla.sudoku.model.move.Move;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoverTestSuite {
    @Test
    public void testRemoveValues() {
        //Given
        SudokuBoard board = new ExampleBoard().getBoard();
        SudokuElement element = board.getSudokuRows().get(0).getElements().get(0);
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
        Tuple3<SudokuElement, Set<Integer>, SudokuBoard> tuple3 = new Tuple3<>(element, set, board);
        //When
        Tuple3<SudokuElement, Move, SudokuBoard> result = Remover.removeValues.apply(tuple3);
        //Then
        Assert.assertEquals(board, result._3);
        Assert.assertTrue(result._2.is());
        Assert.assertEquals(Arrays.asList(4, 5, 6, 7, 8, 9), result._1.getPossibleValues());
    }

    @Test
    public void testRemoveValuesIsNotContains() {
        //Given
        SudokuBoard board = new ExampleBoard().getBoard();
        SudokuElement element = board.getSudokuRows().get(0).getElements().get(0);
        Set<Integer> set = new HashSet<>(Arrays.asList(11, 12, 13));
        Tuple3<SudokuElement, Set<Integer>, SudokuBoard> tuple3 = new Tuple3<>(element, set, board);
        //When
        Tuple3<SudokuElement, Move, SudokuBoard> result = Remover.removeValues.apply(tuple3);
        //Then
        Assert.assertEquals(board, result._3);
        Assert.assertFalse(result._2.is());
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), result._1.getPossibleValues());
    }
}
