package com.kodilla.sudoku.model.result;

import com.kodilla.sudoku.model.board.SudokuBoard;
import com.kodilla.sudoku.model.dto.Tuple3;
import com.kodilla.sudoku.model.error.MyError;

import java.util.Optional;
import java.util.function.Function;

public abstract class StartResult {
    protected final SudokuBoard board;

    protected StartResult(SudokuBoard board) {
        this.board = board;
    }

    public abstract ProcessorResult map(Function<SudokuBoard, ProcessorResult> f);

    private static class Success extends StartResult {

        protected Success(SudokuBoard board) {
            super(board);
        }

        @Override
        public ProcessorResult map(Function<SudokuBoard, ProcessorResult> f) {
            return f.apply(board);
        }
    }

    private static class Failure extends StartResult {
        private final MyError error;

        protected Failure(SudokuBoard board, String message) {
            super(board);
            this.error = new MyError(message);
        }

        @Override
        public ProcessorResult map(Function<SudokuBoard, ProcessorResult> f) {
            return ProcessorResult.failure(new Tuple3<>(board, Optional.of(error), Optional.empty()));
        }
    }

    public static StartResult success(SudokuBoard board) {
        return new Success(board);
    }

    public static StartResult failure(SudokuBoard board, String message) {
        return new Failure(board, message);
    }
}
