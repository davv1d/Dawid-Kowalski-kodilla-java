package com.kodilla.sudoku.dto;

public class Tuple<T, U> {

    public final T _1;
    public final U _2;

    public Tuple(T t, U u) {
        _1 = t;
        _2 = u;
    }
}
