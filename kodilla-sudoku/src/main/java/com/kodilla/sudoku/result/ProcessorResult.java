package com.kodilla.sudoku.result;

import com.kodilla.sudoku.dto.backtrack.Backtrack;
import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.dto.Tuple3;
import com.kodilla.sudoku.error.MyError;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class ProcessorResult {
    protected final Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>> value;

    ProcessorResult(Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>> value) {
        this.value = value;
    }

    public abstract boolean isEnd();

    public abstract ProcessorResult action(Function<Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>>, ProcessorResult> f1, Function<Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>>, ProcessorResult> f2);

    public void effect(Consumer<String> effect) {}

    public SudokuBoard getBoard() {
        return value._1;
    }

    public Optional<Backtrack> getBacktrack() {
        return value._3;
    }

    private static class Success extends ProcessorResult {
        private Success(Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>> value) {
            super(value);
        }

        @Override
        public boolean isEnd() {
            return true;
        }

        public void effect(Consumer<String> effect) {
            effect.accept(value._1.toString());
        }

        @Override
        public ProcessorResult action(Function f1, Function f2) {
            return success(value);
        }

    }

    private static class Failure extends ProcessorResult {
        private Failure(Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>> value) {
            super(value);
        }

        @Override
        public boolean isEnd() {
            return true;
        }

        @Override
        public void effect(Consumer<String> effect) {
            effect.accept(value._2.get().getMessage() + "\n" + value._1.toString());
        }

        @Override
        public ProcessorResult action(Function f1, Function f2) {
            return failure(value);
        }
    }

    private static class Shot extends ProcessorResult {
        private Shot(Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>> value) {
            super(value);
        }

        @Override
        public boolean isEnd() {
            return false;
        }

        @Override
        public ProcessorResult action(Function<Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>>, ProcessorResult> shot, Function<Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>>, ProcessorResult> back) {
            return shot.apply(value);
        }
    }

    private static class Back extends ProcessorResult {
        private Back(Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>> value) {
            super(value);
        }

        @Override
        public boolean isEnd() {
            return false;
        }

        @Override
        public ProcessorResult action(Function<Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>>, ProcessorResult> f1, Function<Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>>, ProcessorResult> f2) {
            return f2.apply(value);
        }
    }

    public static ProcessorResult success(Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>> value) {
        return new Success(value);
    }

    public static ProcessorResult failure(Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>> value) {
        return new Failure(value);
    }

    public static ProcessorResult shot(Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>> value) {
        return new Shot(value);
    }

    public static ProcessorResult back(Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>> value) {
        return new Back(value);
    }
}
