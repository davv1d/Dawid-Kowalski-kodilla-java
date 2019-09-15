package com.kodilla.rps.logic.constant;

public class ErrorInTheGame extends GameResult {
    private static final String ERROR_NOT_FOUND_SYMBOL_NAME = "ERROR_NOT_FOUND_SYMBOL_NAME";
    private static final String ERROR_IN_DEPENDENCIES_AMONG_ELEMENTS = "ERROR_IN_DEPENDENCIES_AMONG_ELEMENTS";
    private static final String ERROR_NOT_CORRECT_GAME_RESULT = "ERROR_NOT_CORRECT_GAME_RESULT";

    private ErrorInTheGame(String value) {
        super(value);
    }

    public static ErrorInTheGame errorNotFoundSymbolName() {
        return new ErrorInTheGame(ERROR_NOT_FOUND_SYMBOL_NAME);
    }

    public static ErrorInTheGame errorInDependenciesAmongSymbols() {
        return new ErrorInTheGame(ERROR_IN_DEPENDENCIES_AMONG_ELEMENTS);
    }

    public static ErrorInTheGame errorNotCorrectGameResult() {
        return new ErrorInTheGame(ERROR_NOT_CORRECT_GAME_RESULT);
    }
}
