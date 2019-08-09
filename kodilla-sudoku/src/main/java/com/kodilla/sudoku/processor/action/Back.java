package com.kodilla.sudoku.processor.action;

import com.kodilla.sudoku.dto.backtrack.Backtrack;
import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.element.Position;
import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.dto.Tuple3;
import com.kodilla.sudoku.error.MyError;
import com.kodilla.sudoku.result.ProcessorResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Back {
    public static ProcessorResult apply(Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>> value) {
        Backtrack backtrack = value._3.get();
        SudokuBoard board = backtrack.getBoard().deepCopy();
        Position pos = backtrack.getPosition();
        List<Integer> possibleValues = board.getSudokuRows().get(pos.getRow()).getElements().get(pos.getColumn()).getPossibleValues();
        List<Integer> newList = new ArrayList<>(possibleValues);
        newList.remove(backtrack.getValue());
        SudokuElement element = new SudokuElement(pos, newList);
        board.getSudokuRows().get(pos.getRow()).getElements().set(pos.getColumn(), element);
        return ProcessorResult.back(new Tuple3<>(board, Optional.empty(), Optional.empty()));

    }
}
