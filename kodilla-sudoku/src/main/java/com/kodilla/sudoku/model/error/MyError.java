package com.kodilla.sudoku.model.error;

public class MyError {
    private final String message;

    public MyError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
