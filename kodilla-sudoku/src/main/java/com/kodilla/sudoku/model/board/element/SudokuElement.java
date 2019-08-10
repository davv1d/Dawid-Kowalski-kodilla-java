package com.kodilla.sudoku.model.board.element;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SudokuElement {
    private final Position position;
    public static final int EMPTY = -1;
    private final int value;
    private final List<Integer> possibleValues;

    public SudokuElement(final int value, final Position position) {
        this.position = position;
        this.value = value;
        this.possibleValues = initializePossibleValues(value);
    }

    public SudokuElement(Position position) {
        this.position = position;
        this.value = EMPTY;
        this.possibleValues = initializePossibleValues(EMPTY);
    }

    public SudokuElement(Position position, List<Integer> possibleValues) {
        this.position = position;
        this.value = EMPTY;
        this.possibleValues = possibleValues;
    }

    public SudokuElement(Position position, int value, List<Integer> possibleValues) {
        this.position = position;
        this.value = value;
        this.possibleValues = possibleValues;
    }

    private List<Integer> initializePossibleValues(final int value) {
        return IntStream.range(1, 10)
                .filter(n -> n != value)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public Position getPosition() {
        return position;
    }

    public int getValue() {
        return value;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    @Override
    public String toString() {
        return value == EMPTY ? " " : Integer.toString(value) ;
    }

    public SudokuElement deepClone() {
        Position position = new Position(this.position.getRow(), this.position.getColumn());
        List<Integer> possible = new ArrayList<>(possibleValues);
        return new SudokuElement(position, value, possible);
    }
}
