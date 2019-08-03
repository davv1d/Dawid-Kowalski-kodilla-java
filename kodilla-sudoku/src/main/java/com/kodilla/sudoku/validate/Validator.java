package com.kodilla.sudoku.validate;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.division.Remover;
import com.kodilla.sudoku.division.ValuePicker;
import com.kodilla.sudoku.division.new_division.BoardDivider;
import com.kodilla.sudoku.division.new_division.Group;
import com.kodilla.sudoku.dto.Tuple;
import com.kodilla.sudoku.dto.Tuple3;
import com.kodilla.sudoku.dto.Tuple4;
import com.kodilla.sudoku.mcase.Case;
import com.kodilla.sudoku.result.ValidResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class Validator {

    static Function<Tuple3<SudokuElement, Boolean, SudokuBoard>, Case> conditionUsedValues = tuple1 ->
            Case.match(
                    Case.nextCase(new Tuple3<>(tuple1._1, tuple1._3, tuple1._2)),
                    Case.finish(() -> tuple1._1.getPossibleValues().size() == 1, ValidResult.write(new Tuple<>(tuple1._1, tuple1._1.getPossibleValues()))),
                    Case.finish(() -> tuple1._1.getPossibleValues().isEmpty(), ValidResult.error(new Tuple<>(tuple1._1, tuple1._2)))
            );

    static Function<Tuple4<SudokuElement, SudokuBoard, List<Integer>, Boolean>, Case> conditionsPossibleValues = tuple ->
            Case.match(
                    Case.nextCase(new Tuple3<>(tuple._1, tuple._2, tuple._4)),
                    Case.finish(() -> !tuple._3.isEmpty(), ValidResult.write(new Tuple<>(tuple._1, tuple._3)))
            );

    static Function<Tuple<SudokuElement, Set<Integer>>, List<Integer>> findValueInPossibleValues = tuple -> {
        for (int i = 0; i < tuple._1.getPossibleValues().size(); i++) {
            if (!tuple._2.contains(tuple._1.getPossibleValues().get(i))) {
                return Collections.singletonList(tuple._1.getPossibleValues().get(i));
            }
        }
        return new ArrayList<>();
    };

    public static Function<Tuple4<SudokuElement, SudokuBoard, Boolean, Group>, Case> checkPossibleValues = tuple -> {
        List<Integer> apply = findValueInPossibleValues.compose(ValuePicker.possibleValues.compose(tuple._4)).apply(new Tuple<>(tuple._1, tuple._2));
        return conditionsPossibleValues.apply(new Tuple4<>(tuple._1, tuple._2, apply, tuple._3));
    };

    public static Function<Tuple<SudokuElement, SudokuBoard>, ValidResult> checkIfNotEmpty = tuple ->
            conditionUsedValues.compose(Remover.remove)
                    .apply(tuple)
                    .checkNext(BoardDivider.row, checkPossibleValues)
                    .checkNext(BoardDivider.column, checkPossibleValues)
                    .checkNext(BoardDivider.sector, checkPossibleValues)
                    .get();

    public static Function<Integer, Function<Tuple<SudokuElement, SudokuBoard>, ValidResult>> check = value ->
            value != SudokuElement.EMPTY ? tuple -> ValidResult.empty(new Tuple<>(tuple._1, false)) : checkIfNotEmpty;
}
