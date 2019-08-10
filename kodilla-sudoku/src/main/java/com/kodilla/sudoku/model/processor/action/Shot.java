package com.kodilla.sudoku.model.processor.action;

import com.kodilla.sudoku.model.board.SudokuBoard;
import com.kodilla.sudoku.model.board.element.SudokuElement;
import com.kodilla.sudoku.model.dto.Tuple3;
import com.kodilla.sudoku.model.dto.backtrack.Backtrack;
import com.kodilla.sudoku.model.error.MyError;
import com.kodilla.sudoku.model.result.ProcessorResult;

import java.util.Optional;

public class Shot {
    public static ProcessorResult apply(Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>> value) {
        Optional<SudokuElement> firstEmpty = value._1.findElementWithTheFewestPossibleValues();
        Integer shotValue = firstEmpty.get().getPossibleValues().get(0);
        Backtrack back = new Backtrack(value._1, firstEmpty.get().getPosition(), shotValue);
        Optional<Backtrack> backtrackOptional = Optional.of(back);
        SudokuElement element = new SudokuElement(shotValue, firstEmpty.get().getPosition());
        SudokuBoard copyBoard = value._1.deepCopy();
        copyBoard.getSudokuRows().get(element.getPosition().getRow()).getElements().set(element.getPosition().getColumn(), element);
        return ProcessorResult.shot(new Tuple3<>(copyBoard, Optional.empty(), backtrackOptional));
    }
}
