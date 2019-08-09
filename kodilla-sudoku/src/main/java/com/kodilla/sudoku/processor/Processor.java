package com.kodilla.sudoku.processor;

import com.kodilla.sudoku.dto.backtrack.Backtrack;
import com.kodilla.sudoku.behaviour.Behaviours;
import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.element.SudokuElement;
import com.kodilla.sudoku.dto.Tuple;
import com.kodilla.sudoku.dto.Tuple3;
import com.kodilla.sudoku.error.MyError;
import com.kodilla.sudoku.move.Move;
import com.kodilla.sudoku.processor.action.Back;
import com.kodilla.sudoku.processor.action.Shot;
import com.kodilla.sudoku.result.ProcessorResult;
import com.kodilla.sudoku.validate.Validator;

import java.util.Optional;

public class Processor {

    public static ProcessorResult start(SudokuBoard sudokuBoard) {
        Optional<Backtrack> backtrack = Optional.empty();
        SudokuBoard board = sudokuBoard.deepCopy();
        boolean isEnd = false;
        ProcessorResult result = null;
        while (!isEnd) {
            result = compose(new Tuple<>(board, backtrack)).action(Shot::apply, Back::apply);
            isEnd = result.isEnd();
            board = result.getBoard();
            backtrack = result.getBacktrack();
        }
      return result;
    }

    public static ProcessorResult compose(Tuple<SudokuBoard, Optional<Backtrack>> value) {
        Tuple<SudokuBoard, Optional<MyError>> proc = checkSudoku(value._1);
        return conditions(new Tuple3<>(proc._1, proc._2, value._2));
    }

    public static ProcessorResult conditions(Tuple3<SudokuBoard, Optional<MyError>, Optional<Backtrack>> value) {
        if (value._1.isFull()) {
            //game over win
            return ProcessorResult.success(value);
        } else if (!value._1.isFull() && value._2.isPresent() && !value._3.isPresent()) {
            //game over error
            return ProcessorResult.failure(value);
        } else if (!value._1.isFull() && value._2.isPresent() && value._3.isPresent()) {
            //back and start next turn
            return ProcessorResult.back(value);
        } else if (!value._1.isFull() && !value._2.isPresent()) {
            //shot
            return ProcessorResult.shot(value);
        }
        return ProcessorResult.failure(value);
    }

    public static Tuple<SudokuBoard, Optional<MyError>> checkSudoku(final SudokuBoard originalBoard) {
        SudokuBoard copyBoard = originalBoard.deepCopy();
        Optional<MyError> error = Optional.empty();
        Move move2 = Move.yes();
        while (move2.is() && !error.isPresent()) {
            Tuple3<SudokuBoard, Move, Optional<MyError>> tuple3 = oneFullCheckAllElement(copyBoard);
            copyBoard = tuple3._1;
            move2 = tuple3._2;
            error = tuple3._3;
        }
        return new Tuple<>(copyBoard, error);
    }

    static Tuple3<SudokuBoard, Move, Optional<MyError>> oneFullCheckAllElement(final SudokuBoard originalBoard) {
        SudokuBoard copy = originalBoard.deepCopy();
        SudokuBoard resultBoard = originalBoard.deepCopy();
        Boolean insideMove = Move.no().is();
        Optional<MyError> error = Optional.empty();
        int row = 0;
        while (row < 9 && !error.isPresent()) {
            int col = 0;
            while (col < 9 && !error.isPresent()) {
                SudokuElement element = copy.getSudokuRows().get(row).getElements().get(col);
                Tuple3<SudokuElement, Move, Optional<MyError>> tupleResult = Validator.check
                        .apply(element.getValue())
                        .apply(new Tuple<>(element, copy))
                        .execute(Behaviours.write, Behaviours.error);
                resultBoard.getSudokuRows().get(row).getElements().set(col, tupleResult._1);
                insideMove = insideMove || tupleResult._2.is();
                error = tupleResult._3;
                col++;
            }
            row++;
        }
        return new Tuple3<>(resultBoard, Move.is(insideMove), error);
    }
}
