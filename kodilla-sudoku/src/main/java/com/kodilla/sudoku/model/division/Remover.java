package com.kodilla.sudoku.model.division;

import com.kodilla.sudoku.model.board.SudokuBoard;
import com.kodilla.sudoku.model.board.element.Position;
import com.kodilla.sudoku.model.board.element.SudokuElement;
import com.kodilla.sudoku.model.dto.Tuple;
import com.kodilla.sudoku.model.dto.Tuple3;
import com.kodilla.sudoku.model.move.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class Remover {

    static final Function<Tuple3<SudokuElement, Set<Integer>, SudokuBoard>, Tuple3<SudokuElement, Move, SudokuBoard>> removeValues = value -> {
        List<Integer> result = new ArrayList<>(value._1.getPossibleValues());
        Move action = Move.is(result.removeAll(value._2));
        return new Tuple3<>(new SudokuElement(new Position(value._1.getPosition()), value._1.getValue(), result), action, value._3);
    };

    public static final Function<Tuple<SudokuElement, SudokuBoard>, Tuple3<SudokuElement, Move, SudokuBoard>> remove = tuple ->
        removeValues.compose(ValuePicker.allUsedValues).apply(tuple);

}
