package com.kodilla.sudoku.board.element;

import com.kodilla.sudoku.division.Position;

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

    public void removeValueFromPossibleValues(int value) {
        possibleValues.remove((Integer) value);
    }

    public boolean containsValue(int value) {
        return possibleValues.contains(value);
    }

    @Override
    public String toString() {
        return "SudokuElement{" +
                "position=" + position +
                ", value=" + value +
                ", possibleValues=" + possibleValues +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SudokuElement element = (SudokuElement) o;

        if (getValue() != element.getValue()) return false;
        if (getPosition() != null ? !getPosition().equals(element.getPosition()) : element.getPosition() != null)
            return false;
        return getPossibleValues() != null ? getPossibleValues().equals(element.getPossibleValues()) : element.getPossibleValues() == null;

    }

    @Override
    public int hashCode() {
        int result = getPosition() != null ? getPosition().hashCode() : 0;
        result = 31 * result + getValue();
        result = 31 * result + (getPossibleValues() != null ? getPossibleValues().hashCode() : 0);
        return result;
    }
}
