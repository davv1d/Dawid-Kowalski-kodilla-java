package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    private ArrayList<Shape> figures = new ArrayList<Shape>();

    public int getFiguresQuantity(){
        return 100;//figures.size();
    }

    public void addFigure(Shape theShape) {
        figures.add(theShape);
    }

    public boolean removeFigure(Shape theShape) {
        boolean result = true;
        if (figures.contains(theShape)) {
            figures.remove(theShape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int shapeNumber) {
        Shape theShape = null;
        if (shapeNumber >= 0 && shapeNumber < figures.size()) {
            theShape = figures.get(shapeNumber);
        }
        return theShape;
    }

    public String showFigures() {
        String figuresNames = "";
        for (Shape figure: this.figures) {
            figuresNames += figure.toString();
        }
        return figuresNames;
    }
}
