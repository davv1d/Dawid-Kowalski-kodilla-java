package com.kodilla.rps.view;

import java.util.Arrays;
import java.util.List;

public class ConsoleValidator {
    private static final List<String> elements = Arrays.asList("1", "2", "3", "4", "5");
    private static final List<String> menu = Arrays.asList("n", "x");
    public static String validElementsValues(String value) {
        if (elements.contains(value)) {
            return value;
        } else {
            System.out.println("Number has to be between 1 and 5");
            return "incorrect";
        }
    }

    public static String validMenuVaues(String value) {
        if (menu.contains(value)) {
            return value;
        } else {
            System.out.println("New game \"n\" or end \"x\"");
            return "incorrect";
        }
    }
}
