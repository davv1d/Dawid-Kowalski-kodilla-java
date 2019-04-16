package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private String triangleName;
    private double field;

    public Triangle(String triangleName, int base, int height) {
        this.triangleName = triangleName;
        this.field = (base * height) / 2;
    }

    @Override
    public String getShapeName() {
        return this.triangleName;
    }

    @Override
    public double getField() {
        return this.field;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "triangleName='" + triangleName + '\'' +
                ", field=" + field +
                '}';
    }
}
