package com.kodilla.sudoku.model.validate;

import com.kodilla.sudoku.model.board.SudokuBoard;
import com.kodilla.sudoku.model.board.element.SudokuElement;
import com.kodilla.sudoku.model.division.BoardDivider;
import com.kodilla.sudoku.model.dto.Tuple;
import com.kodilla.sudoku.model.dto.Tuple3;
import com.kodilla.sudoku.model.result.StartResult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StartValidator {

    public static StartResult check(SudokuBoard board) {
        if (checkRow(board)) {
            return StartResult.failure(board, "ERROR! The same values in row");
        } else if (checkColumn(board)) {
            return StartResult.failure(board, "ERROR! The same values in column");
        } else if (checkSectors(board)) {
            return StartResult.failure(board, "ERROR! The same values in sector");
        } else {
            return StartResult.success(board);
        }
    }

    public static boolean checkColumn(final SudokuBoard board) {
        boolean result = false;
        for (int i = 0; i < board.getSudokuRows().get(0).getElements().size(); i++) {
            SudokuElement element = board.getSudokuRows().get(0).getElements().get(i);
            result = result || condition.compose(getValues).compose(getElements).compose(BoardDivider.column).apply(new Tuple<>(element, board));
        }
        return result;
    }

    public static boolean checkRow(final SudokuBoard board) {
        boolean result = false;
        for (int i = 0; i < board.getSudokuRows().size(); i++) {
            List<SudokuElement> elements = board.getSudokuRows().get(i).getElements();
            result = result || condition.compose(getValues).apply(elements);
        }
        return result;
    }

    public static boolean checkSectors(final SudokuBoard board) {
        boolean result = false;
        for (int i = 0; i < board.getSudokuRows().size(); i = i + 3) {
            SudokuElement element = board.getSudokuRows().get(i).getElements().get(i);
            result = result || condition.compose(getValues).compose(getElements).compose(BoardDivider.sector).apply(new Tuple<>(element, board));
        }
        return result;
    }

    public static Function<Tuple3<SudokuElement, List<SudokuElement>, SudokuBoard>, List<SudokuElement>> getElements = value -> {
        List<SudokuElement> sudokuElements = new ArrayList<>(value._2);
        sudokuElements.add(value._1.deepClone());
        return sudokuElements;
    };

    public static Function<List<SudokuElement>, List<Integer>> getValues = sudokuElements ->
            sudokuElements.stream()
                    .filter(element -> element.getValue() != SudokuElement.EMPTY)
                    .map(SudokuElement::getValue)
                    .collect(Collectors.toList());

    public static Function<List<Integer>, Boolean> condition = integers ->
            integers.size() > new HashSet<>(integers).size();
}
