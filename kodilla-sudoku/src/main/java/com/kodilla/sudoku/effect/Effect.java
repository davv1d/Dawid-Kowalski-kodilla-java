package com.kodilla.sudoku.effect;

import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.dto.Tuple;

public interface Effect {
    Tuple<SudokuElement, Boolean> effect();
}
