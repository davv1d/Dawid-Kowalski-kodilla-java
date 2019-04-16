package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape {
    private String squareName;
    private double field;

    public Square(String squareName, int sideLength) {
        this.squareName = squareName;
        this.field = sideLength * sideLength;
    }

    @Override
    public String getShapeName() {
        return this.squareName;
    }

    @Override
    public double getField() {
        return this.field;
    }

    @Override
    public String toString() {
        return "Square{" +
                "squareName='" + squareName + '\'' +
                ", field=" + field +
                '}';
    }
}
