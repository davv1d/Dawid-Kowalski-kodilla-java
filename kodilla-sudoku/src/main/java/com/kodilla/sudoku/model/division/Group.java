package com.kodilla.sudoku.model.division;

import com.kodilla.sudoku.model.board.SudokuBoard;
import com.kodilla.sudoku.model.board.element.SudokuElement;
import com.kodilla.sudoku.model.dto.Tuple;
import com.kodilla.sudoku.model.dto.Tuple3;

import java.util.List;
import java.util.function.Function;

@FunctionalInterface
public interface Group extends Function<Tuple<SudokuElement, SudokuBoard>, Tuple3<SudokuElement, List<SudokuElement>, SudokuBoard>> { }
