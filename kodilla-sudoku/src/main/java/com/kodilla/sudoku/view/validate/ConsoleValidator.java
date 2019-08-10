package com.kodilla.sudoku.view.validate;

import java.util.Arrays;
import java.util.List;

public class ConsoleValidator {
    private static final List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    public static int validValues(int value) {
        if (values.contains(value)) {
            return value;
        } else {
            System.out.println("Number has to be between 1 and 9");
            return -1;
        }
    }
}
