package com.kodilla.sudoku.division.new_division;

import com.kodilla.sudoku.ExampleBoard;
import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.dto.Tuple;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class NewBoardDividerTestSuite {
    private ExampleBoard board = new ExampleBoard();

    @Test
    public void testGetRow() {
        //Given
        List<SudokuElement> elements = board.getBoard().getSudokuRows().get(5).getElements();
        SudokuElement element = elements.get(4);
        //When
        Tuple<SudokuElement, List<SudokuElement>> result = NewBoardDivider.row.apply(new Tuple<>(element, board.getBoard()));
        //Then
        Assert.assertEquals(8, result._2.size());
        Assert.assertFalse(result._2.contains(element));
    }

    @Test
    public void testGetColumn() {
        //Given
        SudokuElement element = board.getBoard().getSudokuRows().get(1).getElements().get(1);
        //When
        Tuple<SudokuElement, List<SudokuElement>> result = NewBoardDivider.column.apply(new Tuple<>(element, board.getBoard()));
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
        Tuple<SudokuElement, List<SudokuElement>> result = NewBoardDivider.sector.apply(new Tuple<>(element, board.getBoard()));
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
        Tuple<SudokuElement, List<SudokuElement>> result = NewBoardDivider.getAllGroup.apply(new Tuple<>(element, board.getBoard()));
        //Then
        Assert.assertEquals(20, result._2.size());
        System.out.println(result._2);
    }
}
