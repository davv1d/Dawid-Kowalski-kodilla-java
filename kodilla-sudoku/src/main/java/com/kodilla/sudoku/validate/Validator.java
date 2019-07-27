package com.kodilla.sudoku.validate;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.division.ValuePicker;
import com.kodilla.sudoku.dto.Tuple;
import com.kodilla.sudoku.effect.Effect;
import com.kodilla.sudoku.effect.EffectRemove;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validator {


    public static final Effect test(Tuple<SudokuElement, SudokuBoard> tuple) {
        Tuple<SudokuElement, Set<Integer>> setTuple = ValuePicker.allUsedValues.apply(tuple);
        if (setTuple._1.getPossibleValues().size() > 1) {
            return new EffectRemove(setTuple);
        }
        return null;
    }

    public static Tuple<List<Integer>, Boolean> checkPossibleValues(List<Integer> possibleValues, List<Integer> possibleValuesInGroup) {
        List<Integer> collect = possibleValues.stream()
                .filter(integer -> !possibleValuesInGroup.contains(integer))
                .collect(Collectors.toList());
        return new Tuple<>(collect, collect.isEmpty());
    }


}
