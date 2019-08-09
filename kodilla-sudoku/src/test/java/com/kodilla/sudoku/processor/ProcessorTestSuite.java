package com.kodilla.sudoku.processor;

import com.kodilla.sudoku.ExampleBoard;
import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.element.Position;
import com.kodilla.sudoku.dto.Tuple;
import com.kodilla.sudoku.dto.Tuple3;
import com.kodilla.sudoku.dto.backtrack.Backtrack;
import com.kodilla.sudoku.error.MyError;
import com.kodilla.sudoku.move.Move;
import com.kodilla.sudoku.result.ProcessorResult;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class ProcessorTestSuite {
    @Test
    public void testOneFullCheckAllElement() {
        //Given
        SudokuBoard board = new ExampleBoard().getBoard();
        //When
        Tuple3<SudokuBoard, Move, Optional<MyError>> tuple = Processor.oneFullCheckAllElement(board);
        //Then
        System.out.println(tuple._1);
        Assert.assertNotEquals(board, tuple._1);
    }

    @Test
    public void testCheckSudoku() {
        //Given
        SudokuBoard board = new ExampleBoard().getBoard();
        //When
        Tuple<SudokuBoard, Optional<MyError>> tuple = Processor.checkSudoku(board);
        //Then
        System.out.println(tuple._1);
        Assert.assertNotEquals(board, tuple._1);
    }

    @Test
    public void testStart() {
        //Given
        SudokuBoard board = new ExampleBoard().getBoard();
        //When
        ProcessorResult result = Processor.start(board);
        result.effect(System.out::println);
        //Then
        System.out.println(result);
    }

    @Test
    public void testConditions() {
        //Given
        SudokuBoard board = new ExampleBoard().getBoard();
        Backtrack backtrack = new Backtrack(board, new Position(1, 2), 5);
        Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>> tuple = new Tuple3<>(board, Optional.empty(), Optional.of(backtrack));
        //When
        ProcessorResult conditions = Processor.conditions(tuple);
        //Then
        System.out.println(conditions);

    }


}
