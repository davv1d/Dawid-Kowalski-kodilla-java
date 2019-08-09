package com.kodilla.sudoku.division.new_division;

import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.dto.Tuple3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BoardDivider {

    public static final Group row = tuple -> {
        List<SudokuElement> elements = tuple._2.getSudokuRows().get(tuple._1.getPosition().getRow()).getElements().stream()
                .filter(element1 -> !element1.getPosition().equals(tuple._1.getPosition()))
                .collect(Collectors.toList());
        return new Tuple3<>(tuple._1, elements,tuple._2);
    };

    public static final Group column = tuple -> {
        List<SudokuElement> elements = tuple._2.getSudokuRows().stream()
                .map(sudokuRow -> sudokuRow.getElements().get(tuple._1.getPosition().getColumn()))
                .filter(element1 -> !element1.getPosition().equals(tuple._1.getPosition()))
                .collect(Collectors.toList());
        return new Tuple3<>(tuple._1, elements, tuple._2);
    };

    public static final Group sector = tuple -> {
        List<SudokuElement> result = new ArrayList<>();
        for (Integer secRow : sectorValues(tuple._1.getPosition().getRow())) {
            for (Integer secCol : sectorValues(tuple._1.getPosition().getColumn())) {
                SudokuElement sudokuElement = tuple._2.getSudokuRows().get(secRow).getElements().get(secCol);
                if (!sudokuElement.getPosition().equals(tuple._1.getPosition()))
                    result.add(sudokuElement);
            }
        }
        return new Tuple3<>(tuple._1, result, tuple._2);
    };

    public static final Group getAllGroup = tuple -> {
        List<SudokuElement> result = new ArrayList<>(row.apply(tuple)._2);
        List<SudokuElement> elements = column.apply(tuple)._2;
        elements.addAll(sector.apply(tuple)._2);
        for (SudokuElement sudokuElement : elements) {
            if (!result.contains(sudokuElement))
                result.add(sudokuElement);
        }
        return new Tuple3<>(tuple._1, result, tuple._2);
    };

    static List<Integer> sectorValues(int value) {
        if (value < 3) {
            return Arrays.asList(0,1,2);
        } else if (value < 6) {
            return Arrays.asList(3,4,5);
        } else {
            return Arrays.asList(6,7,8);
        }
    }
}
