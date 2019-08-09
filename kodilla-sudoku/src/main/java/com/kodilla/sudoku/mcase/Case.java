package com.kodilla.sudoku.mcase;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.division.new_division.Group;
import com.kodilla.sudoku.dto.Tuple;
import com.kodilla.sudoku.dto.Tuple3;
import com.kodilla.sudoku.dto.Tuple4;
import com.kodilla.sudoku.move.Move;
import com.kodilla.sudoku.result.ValidResult;

import java.util.function.Function;
import java.util.function.Supplier;

public abstract class Case {
    private final Supplier<Boolean> condition;

    Case(Supplier<Boolean> condition) {
        this.condition = condition;
    }

    public abstract ValidResult get();
    public abstract Case checkNext(Group group, Function<Tuple4<SudokuElement, SudokuBoard, Move, Group>, Case> f);

    private static class NextCase extends Case {
        private final Tuple3<SudokuElement, SudokuBoard, Move> tuple;
        private NextCase(Supplier<Boolean> condition,
                         Tuple3<SudokuElement, SudokuBoard, Move> tuple) {
            super(condition);
            this.tuple = tuple;
        }

        @Override
        public ValidResult get() {
            return ValidResult.empty(new Tuple<>(tuple._1, tuple._3));
        }

        @Override
        public Case checkNext(Group group, Function<Tuple4<SudokuElement, SudokuBoard, Move, Group>, Case> f) {
            return f.apply(new Tuple4<>(tuple._1, tuple._2, tuple._3, group));
        }
    }

    private static class Finish extends Case {
        private final ValidResult validResult;
        private Finish(Supplier<Boolean> condition, ValidResult validResult) {
            super(condition);
            this.validResult = validResult;
        }

        @Override
        public ValidResult get() {
            return validResult;
        }

        @Override
        public Case checkNext(Group group, Function<Tuple4<SudokuElement, SudokuBoard, Move, Group>, Case> f) {
            return this;
        }
    }

    public static NextCase nextCase(Tuple3<SudokuElement, SudokuBoard, Move> t) {
        return new NextCase(() -> true, t);
    }

    public static Finish finish(Supplier<Boolean> condition, ValidResult validResult) {
        return new Finish(condition, validResult);
    }

    public static Case match(Case next, Case... matches) {
        for (Case acase : matches) {
            if (acase.condition.get()) return acase;
        }
        return next;
    }
}
