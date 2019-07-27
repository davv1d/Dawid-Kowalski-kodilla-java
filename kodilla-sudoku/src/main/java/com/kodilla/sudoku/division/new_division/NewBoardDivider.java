package com.kodilla.sudoku.division.new_division;

import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.division.Sectors;
import com.kodilla.sudoku.dto.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NewBoardDivider {

    public static final NewGroup row = tuple -> {
        List<SudokuElement> elements = tuple._2.getSudokuRows().stream()
                .filter(sudokuRow -> sudokuRow.getElements().contains(tuple._1))
                .flatMap(sudokuRow -> sudokuRow.getElements().stream())
                .filter(element1 -> !element1.equals(tuple._1))
                .collect(Collectors.toList());
        return new Tuple<>(tuple._1, elements);
    };

    public static final NewGroup column = tuple -> {
        List<SudokuElement> elements = tuple._2.getSudokuRows().stream()
                .map(sudokuRow -> sudokuRow.getElements().get(tuple._1.getPosition().getColumn()))
                .filter(element1 -> !element1.equals(tuple._1))
                .collect(Collectors.toList());
        return new Tuple<>(tuple._1, elements);
    };

    public static final NewGroup sector = tuple -> {
        List<SudokuElement> result = new ArrayList<>();
        for (Integer secRow : Sectors.get(tuple._1.getPosition().getRow())) {
            for (Integer secCol : Sectors.get(tuple._1.getPosition().getColumn())) {
                SudokuElement sudokuElement = tuple._2.getSudokuRows().get(secRow).getElements().get(secCol);
                if (!sudokuElement.equals(tuple._1))
                    result.add(sudokuElement);
            }
        }
        return new Tuple<>(tuple._1, result);
    };

    public static final NewGroup getAllGroup = tuple -> {
        List<SudokuElement> result = new ArrayList<>(row.apply(tuple)._2);
        List<SudokuElement> elements = column.apply(tuple)._2;
        elements.addAll(sector.apply(tuple)._2);
        for (SudokuElement sudokuElement : elements) {
            if (!result.contains(sudokuElement))
                result.add(sudokuElement);
        }
        return new Tuple<>(tuple._1, result);
    };
}
