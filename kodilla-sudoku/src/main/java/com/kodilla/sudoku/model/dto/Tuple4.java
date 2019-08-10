package com.kodilla.sudoku.model.dto;

public class Tuple4<T, U, R,E> extends Tuple3<T, U, R> {
    public final E _4;
    public Tuple4(T t, U u, R r, E e) {
        super(t, u, r);
        _4 = e;
    }
}
