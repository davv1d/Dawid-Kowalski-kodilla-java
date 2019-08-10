package com.kodilla.sudoku.model.dto.backtrack;

import com.kodilla.sudoku.model.board.SudokuBoard;
import com.kodilla.sudoku.model.board.element.Position;

public class Backtrack {
    private final SudokuBoard board;
    private final Position position;
    private final int value;

    public Backtrack(SudokuBoard board, Position position, int value) {
        this.board = board;
        this.position = position;
        this.value = value;
    }

    public SudokuBoard getBoard() {
        return board;
    }

    public Position getPosition() {
        return position;
    }

    public int getValue() {
        return value;
    }
}
