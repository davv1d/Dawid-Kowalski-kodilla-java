package com.kodilla.sudoku.division;

import java.util.Arrays;
import java.util.List;

public class Sectors {
    public static List<Integer> get(int value) {
        if (value < 3) {
            return Arrays.asList(0,1,2);
        } else if (value < 6) {
            return Arrays.asList(3,4,5);
        } else {
            return Arrays.asList(6,7,8);
        }
    }
}
