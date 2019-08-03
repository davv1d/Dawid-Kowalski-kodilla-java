package com.kodilla.sudoku.division;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.division.new_division.BoardDivider;
import com.kodilla.sudoku.dto.Tuple;
import com.kodilla.sudoku.dto.Tuple3;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ValuePicker {

    public static final Function<Tuple3<SudokuElement, List<SudokuElement>, SudokuBoard>, Tuple3<SudokuElement, Set<Integer>, SudokuBoard>> usedValues = tuple ->
    {
        Set<Integer> collect = tuple._2.stream()
                .filter(sudokuElement -> sudokuElement.getValue() != SudokuElement.EMPTY)
                .map(SudokuElement::getValue)
                .collect(Collectors.toSet());
        return new Tuple3<>(tuple._1, collect,tuple._3);
    };

    public static final Function<Tuple<SudokuElement, SudokuBoard>, Tuple3<SudokuElement, Set<Integer>, SudokuBoard>> allUsedValues =
            boardTuple ->
                    ValuePicker.usedValues.compose(BoardDivider.getAllGroup)
                            .apply(new Tuple<>(boardTuple._1, boardTuple._2));

    public static final Function<Tuple3<SudokuElement, List<SudokuElement>,SudokuBoard>, Tuple<SudokuElement, Set<Integer>>> possibleValues = tuple ->
    {
        Set<Integer> collect = tuple._2.stream()
                .filter(sudokuElement -> sudokuElement.getValue() == SudokuElement.EMPTY)
                .flatMap(sudokuElement -> sudokuElement.getPossibleValues().stream())
                .collect(Collectors.toSet());
        return new Tuple<>(tuple._1, collect);
    };
}
