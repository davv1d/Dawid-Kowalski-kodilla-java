package com.kodilla.sudoku.division;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.element.Position;
import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.dto.Tuple;
import com.kodilla.sudoku.dto.Tuple3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class Remover {

    private static final Function<Tuple3<SudokuElement, Set<Integer>, SudokuBoard>, Tuple3<SudokuElement, Boolean, SudokuBoard>> removeValues = value -> {
        List<Integer> result = new ArrayList<>(value._1.getPossibleValues());
        boolean action = result.removeAll(value._2);
        return new Tuple3<>(new SudokuElement(new Position(value._1.getPosition()), value._1.getValue(), result), action, value._3);
    };

    public static final Function<Tuple<SudokuElement, SudokuBoard>, Tuple3<SudokuElement, Boolean, SudokuBoard>> remove = tuple ->
        removeValues.compose(ValuePicker.allUsedValues).apply(tuple);

}
