package com.kodilla.testing.shape;

public class Circle implements Shape {
    private String circleName;
    private double field;

    public Circle(String circleName, int radius) {
        this.circleName = circleName;
        this.field = Math.PI * (radius * radius);

    }

    @Override
    public String getShapeName() {
        return this.circleName;
    }

    @Override
    public double getField() {
        return this.field;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "circleName='" + circleName + '\'' +
                ", field=" + field +
                '}';
    }
}
