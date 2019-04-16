package com.kodilla.testing.shape;

import org.junit.Assert;
import org.junit.Test;

public class ShapeCollectorTestSuite {
    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Square theSquare = new Square("little", 10);
        //When
        shapeCollector.addFigure(theSquare);
        //Then
        Assert.assertEquals(theSquare, shapeCollector.getFigure(0));
    }

    @Test
    public void testRemoveFigureNotExisting() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle theCircle = new Circle("round", 5);
        //When
        boolean result = shapeCollector.removeFigure(theCircle);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle theTriangle = new Triangle("big", 3, 4);
        shapeCollector.addFigure(theTriangle);
        //When
        boolean result = shapeCollector.removeFigure(theTriangle);
        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, shapeCollector.getFiguresQuantity());
    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Square theSquare = new Square("orange", 2);
        shapeCollector.addFigure(theSquare);
        //When
        Shape retrievedFigure = shapeCollector.getFigure(0);
        //Then
        Assert.assertEquals(theSquare, retrievedFigure);
    }

    @Test
    public void testShowFigures() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square("Square 1", 5);
        Shape circle = new Circle("Circle 1", 2);
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(circle);
        String expectedString = square.toString() + circle.toString();
        //When
        String resultString = shapeCollector.showFigures();
        //Then
        Assert.assertEquals(expectedString, resultString);
    }
}
