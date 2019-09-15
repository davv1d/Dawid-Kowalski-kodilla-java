package com.kodilla.rps.constant;

public class ErrorInGame extends GameResult {
    private static final String ERROR_NOT_FOUND_NAME = "TEST_NAME";
    private static final String ERROR_IN_DEPENDENCIES_AMONG_ELEMENTS = "ERROR_IN_DEPENDENCIES_AMONG_ELEMENTS";
    private static final String ERROR_NOT_CORRECT_GAME_RESULT = "ERROR_NOT_CORRECT_GAME_RESULT";
    protected ErrorInGame(String value) {
        super(value);
    }

    public static ErrorInGame errorNotFoundName() {
       return new ErrorInGame(ERROR_NOT_FOUND_NAME);
    }

    public static ErrorInGame errorInDependenciesAmongElement() {
        return new ErrorInGame(ERROR_IN_DEPENDENCIES_AMONG_ELEMENTS);
    }

    public static ErrorInGame errorNotCorrectGameResult() {
        return new ErrorInGame(ERROR_NOT_CORRECT_GAME_RESULT);
    }
}
