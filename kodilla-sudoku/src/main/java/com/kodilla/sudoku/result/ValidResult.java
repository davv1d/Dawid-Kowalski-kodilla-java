package com.kodilla.sudoku.result;

import com.kodilla.sudoku.behaviour.Behaviour;
import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.dto.Tuple;
import com.kodilla.sudoku.dto.Tuple3;
import com.kodilla.sudoku.error.MyError;

import java.util.List;
import java.util.Optional;

public abstract class ValidResult {

    public abstract Tuple3<SudokuElement, Boolean, Optional<MyError>> execute(Behaviour<Tuple<SudokuElement, List<Integer>>> wr, Behaviour<Tuple<SudokuElement, Boolean>> er);

    private static class Writer extends ValidResult {
        private Tuple<SudokuElement, List<Integer>> value;

        Writer(Tuple<SudokuElement, List<Integer>> value) {
            this.value = value;
        }

        @Override
        public Tuple3<SudokuElement, Boolean, Optional<MyError>> execute(Behaviour<Tuple<SudokuElement, List<Integer>>> wr, Behaviour<Tuple<SudokuElement, Boolean>> er) {
            return wr.apply(value);
        }
    }

    private static class MyErrorTest extends ValidResult {
        private final Tuple<SudokuElement, Boolean> value;
        private MyErrorTest(Tuple<SudokuElement, Boolean> value) {
            this.value = value;
        }

        @Override
        public Tuple3<SudokuElement, Boolean, Optional<MyError>> execute(Behaviour<Tuple<SudokuElement, List<Integer>>> wr, Behaviour<Tuple<SudokuElement, Boolean>> er) {
            return er.apply(value);
        }
    }

    private static class Empty extends ValidResult {
        private final Tuple<SudokuElement, Boolean> value;

        private Empty(Tuple<SudokuElement, Boolean> value) {
            this.value = value;
        }

        @Override
        public Tuple3<SudokuElement, Boolean, Optional<MyError>> execute(Behaviour<Tuple<SudokuElement, List<Integer>>> wr, Behaviour<Tuple<SudokuElement, Boolean>> er) {
            return new Tuple3<>(value._1, value._2, Optional.empty());
        }

        @Override
        public String toString() {
            return "Empty{" +
                    "value=" + value._1 + " and " + value._2 +
                    "} " + super.toString();
        }
    }


    public static ValidResult write(Tuple<SudokuElement, List<Integer>> value) {
        return new Writer(value);
    }
    public static ValidResult error(Tuple<SudokuElement, Boolean> value) { return new MyErrorTest(value);}
    public static ValidResult empty(Tuple<SudokuElement, Boolean> value) {return new Empty(value);}
}
