package com.kodilla.sudoku.division;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.division.new_division.NewBoardDivider;
import com.kodilla.sudoku.dto.Tuple;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ValuePicker {


    public static final Function<Tuple<SudokuElement, List<SudokuElement>>, Tuple<SudokuElement, Set<Integer>>> usedValues = tuple ->
    {
        Set<Integer> collect = tuple._2.stream()
                .filter(sudokuElement -> sudokuElement.getValue() != SudokuElement.EMPTY)
                .map(SudokuElement::getValue)
                .collect(Collectors.toSet());
        return new Tuple<>(tuple._1, collect);
    };

    public static final Function<Tuple<SudokuElement, SudokuBoard>, Tuple<SudokuElement, Set<Integer>>> allUsedValues =
            boardTuple ->
                    ValuePicker.usedValues.compose(NewBoardDivider.getAllGroup)
                            .apply(new Tuple<>(boardTuple._1, boardTuple._2));

    public static final Function<Tuple<SudokuElement, List<SudokuElement>>, Tuple<SudokuElement, Set<Integer>>> possibleValues = tuple ->
    {
        Set<Integer> collect = tuple._2.stream()
                .filter(sudokuElement -> sudokuElement.getValue() == SudokuElement.EMPTY)
                .flatMap(sudokuElement -> sudokuElement.getPossibleValues().stream())
                .collect(Collectors.toSet());
        return new Tuple<>(tuple._1, collect);
    };
}
