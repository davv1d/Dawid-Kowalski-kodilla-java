package com.kodilla.sudoku.model.division;

import com.kodilla.sudoku.ExampleBoard;
import com.kodilla.sudoku.model.board.SudokuBoard;
import com.kodilla.sudoku.model.board.element.SudokuElement;
import com.kodilla.sudoku.model.dto.Tuple;
import com.kodilla.sudoku.model.dto.Tuple3;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BoardDividerTestSuite {
    private ExampleBoard board = new ExampleBoard();

    @Test
    public void testGetRow() {
        //Given
        List<SudokuElement> elements = board.getBoard().getSudokuRows().get(5).getElements();
        SudokuElement element = elements.get(4);
        //When
        Tuple3<SudokuElement, List<SudokuElement>, SudokuBoard> result = BoardDivider.row.apply(new Tuple<>(element, board.getBoard()));
        //Then
        Assert.assertEquals(8, result._2.size());
        Assert.assertFalse(result._2.contains(element));
    }

    @Test
    public void testGetColumn() {
        //Given
        SudokuElement element = board.getBoard().getSudokuRows().get(1).getElements().get(1);
        //When
        Tuple3<SudokuElement, List<SudokuElement>, SudokuBoard> result = BoardDivider.column.apply(new Tuple<>(element, board.getBoard()));
        //Then
        Assert.assertEquals(8, result._2.size());
        Assert.assertFalse(result._2.contains(element));
        System.out.println(result._2);
    }

    @Test
    public void testGetSector() {
        //Given
        SudokuElement element = board.getBoard().getSudokuRows().get(4).getElements().get(4);
        //When
        Tuple3<SudokuElement, List<SudokuElement>, SudokuBoard> result = BoardDivider.sector.apply(new Tuple<>(element, board.getBoard()));
        //Then
        Assert.assertEquals(8, result._2.size());
        Assert.assertFalse(result._2.contains(element));
        System.out.println(result._2);
    }

    @Test
    public void testGetAllGroup() {
        //Given
        SudokuElement element = board.getBoard().getSudokuRows().get(0).getElements().get(0);
        //When
        Tuple3<SudokuElement, List<SudokuElement>, SudokuBoard> result = BoardDivider.getAllGroup.apply(new Tuple<>(element, board.getBoard()));
        //Then
        Assert.assertEquals(20, result._2.size());
        System.out.println(result._2);
    }

    @Test
    public void testSectorsValue() {
        //Given
        int value1 = 2;
        int value2 = 3;
        int value3 = 6;
        List<Integer> expected1 = Arrays.asList(0,1,2);
        List<Integer> expected2 = Arrays.asList(3,4,5);
        List<Integer> expected3 = Arrays.asList(6,7,8);
        //When
        List<Integer> result1 = BoardDivider.sectorValues(value1);
        List<Integer> result2 = BoardDivider.sectorValues(value2);
        List<Integer> result3 = BoardDivider.sectorValues(value3);
        //Then
        Assert.assertEquals(expected1, result1);
        Assert.assertEquals(expected2, result2);
        Assert.assertEquals(expected3, result3);


    }
}
