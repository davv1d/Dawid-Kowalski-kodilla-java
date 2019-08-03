package com.kodilla.sudoku.board;

import org.junit.Test;

public class EmptyBoardTestSuite {

    @Test
    public void testEmptyBoard() {
        //Given
        //When
        EmptyBoard emptyBoard = new EmptyBoard();
        SudokuBoard board = emptyBoard.getBoard();
        //Then
        System.out.println(board);
    }
}
