package com.kodilla.patterns.factory;

import org.junit.Assert;
import org.junit.Test;

public class ShapeFactoryTestSuite {
    @Test
    public void testFactoryCircle() {
        //Given
        ShapeFactory shapeFactory = new ShapeFactory();
        //When
        Shape shape = shapeFactory.makeShape(ShapeFactory.CIRCLE);
        //Then
        Assert.assertEquals(Math.PI * Math.pow(4.50, 2.0), shape.getArea(), 0);
        Assert.assertEquals("The rounded circle", shape.getName());
    }

    @Test
    public void testFactorySquare() {
        //Given
        ShapeFactory shapeFactory = new ShapeFactory();
        //When
        Shape shape = shapeFactory.makeShape(ShapeFactory.SQUARE);
        //Then
        Assert.assertEquals(28.0, shape.getCircumference(), 0);
        Assert.assertEquals("The angular square", shape.getName());
    }

    @Test
    public void testFactoryRectangle() {
        //Given
        ShapeFactory shapeFactory = new ShapeFactory();
        //When
        Shape shape = shapeFactory.makeShape(ShapeFactory.RECTANGLE);
        //Then
        Assert.assertEquals(37.5, shape.getArea(), 0);
        Assert.assertEquals("The long rectangle", shape.getName());
    }
}
