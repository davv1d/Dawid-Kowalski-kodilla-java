package com.kodilla.sudoku.error;

public class MyError {
    private final String message;

    public MyError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
