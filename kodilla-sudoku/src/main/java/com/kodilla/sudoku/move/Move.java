package com.kodilla.sudoku.move;

public final class Move {
    private final Boolean is;

    private Move(Boolean is) {
        this.is = is;
    }

    public static Move yes() {
        return new Move(true);
    }

    public static Move no() {
        return new Move(false);
    }

    public static Move is(Boolean is) {
        return new Move(is);
    }
//
//    public Move(Boolean is) {
//        this.is = is;
//    }


    public Boolean is() {
        return is;
    }

}
