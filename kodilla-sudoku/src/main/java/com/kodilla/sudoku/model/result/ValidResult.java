package com.kodilla.sudoku.model.result;

import com.kodilla.sudoku.model.behaviour.Behaviour;
import com.kodilla.sudoku.model.board.element.SudokuElement;
import com.kodilla.sudoku.model.dto.Tuple;
import com.kodilla.sudoku.model.dto.Tuple3;
import com.kodilla.sudoku.model.error.MyError;
import com.kodilla.sudoku.model.move.Move;

import java.util.List;
import java.util.Optional;

public abstract class ValidResult {

    public abstract Tuple3<SudokuElement, Move, Optional<MyError>> execute(Behaviour<Tuple<SudokuElement, List<Integer>>> wr, Behaviour<Tuple<SudokuElement, Move>> er);

    private static class Writer extends ValidResult {
        private Tuple<SudokuElement, List<Integer>> value;

        Writer(Tuple<SudokuElement, List<Integer>> value) {
            this.value = value;
        }

        @Override
        public Tuple3<SudokuElement, Move, Optional<MyError>> execute(Behaviour<Tuple<SudokuElement, List<Integer>>> wr, Behaviour<Tuple<SudokuElement, Move>> er) {
            return wr.apply(value);
        }
    }

    private static class Failure extends ValidResult {
        private final Tuple<SudokuElement, Move> value;
        private Failure(Tuple<SudokuElement, Move> value) {
            this.value = value;
        }

        @Override
        public Tuple3<SudokuElement, Move, Optional<MyError>> execute(Behaviour<Tuple<SudokuElement, List<Integer>>> wr, Behaviour<Tuple<SudokuElement, Move>> er) {
            return er.apply(value);
        }
    }

    private static class OnlyMove extends ValidResult {
        private final Tuple<SudokuElement, Move> value;

        private OnlyMove(Tuple<SudokuElement, Move> value) {
            this.value = value;
        }

        @Override
        public Tuple3<SudokuElement, Move, Optional<MyError>> execute(Behaviour<Tuple<SudokuElement, List<Integer>>> wr, Behaviour<Tuple<SudokuElement, Move>> er) {
            return new Tuple3<>(value._1, value._2, Optional.empty());
        }

        @Override
        public String toString() {
            return "OnlyMove{" +
                    "value=" + value._1 + " and " + value._2 +
                    "} " + super.toString();
        }
    }


    public static ValidResult write(Tuple<SudokuElement, List<Integer>> value) {
        return new Writer(value);
    }
    public static ValidResult error(Tuple<SudokuElement, Move> value) { return new Failure(value);}
    public static ValidResult onlyMove(Tuple<SudokuElement, Move> value) {return new OnlyMove(value);}
}
