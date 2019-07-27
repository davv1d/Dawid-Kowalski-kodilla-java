package com.kodilla.sudoku.effect;

import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.division.Position;
import com.kodilla.sudoku.dto.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EffectRemove implements Effect {

    private final Tuple<SudokuElement, Set<Integer>> sudokuElementSetTuple;


    public EffectRemove(Tuple<SudokuElement, Set<Integer>> sudokuElementSetTuple) {
        this.sudokuElementSetTuple = sudokuElementSetTuple;
    }


    @Override
    public Tuple<SudokuElement, Boolean> effect() {
        List<Integer> result = new ArrayList<>(sudokuElementSetTuple._1.getPossibleValues());
        boolean action = result.removeAll(sudokuElementSetTuple._2);
        return new Tuple<>(new SudokuElement(new Position(sudokuElementSetTuple._1.getPosition()),sudokuElementSetTuple._1.getValue(), result), action);
    }
}
