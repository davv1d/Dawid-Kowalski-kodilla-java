package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PizzaOrderTestSuite {
    @Test
    public void testBasicPizzaGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        //When
        BigDecimal cost = pizzaOrder.getCost();
        //Then
        System.out.println("Basic pizza: " + cost);
        assertEquals(new BigDecimal(15), cost);
    }

    @Test
    public void testBasicPizzaGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        //When
        String description = pizzaOrder.getDescription();
        //Then
        System.out.println("Basic pizza: " + description);
        assertEquals("Pizza, cheese and sos", description);
    }

    @Test
    public void testPizzaWithBaconGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new PizzaWithBacon(pizzaOrder);
        //When
        BigDecimal cost = pizzaOrder.getCost();
        //Then
        System.out.println("Pizza with bacon: " + cost);
        assertEquals(new BigDecimal(20), cost);
    }

    @Test
    public void testPizzaWithBaconGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new PizzaWithBacon(pizzaOrder);
        //When
        String description = pizzaOrder.getDescription();
        //Then
        System.out.println("Pizza with bacon: " + description);
        assertEquals("Pizza, cheese and sos + bacon", description);
    }

    @Test
    public void testPizzaWithBaconHanAndPineappleGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new PizzaWithBacon(pizzaOrder);
        pizzaOrder = new PizzaWithHam(pizzaOrder);
        pizzaOrder = new PizzaWithPineapple(pizzaOrder);
        //When
        BigDecimal cost = pizzaOrder.getCost();
        //Then
        System.out.println("Pizza with bacon, ham and pineapple: " + cost);
        assertEquals(new BigDecimal(29), cost);
    }

    @Test
    public void testPizzaWithBaconHamAndPineappleGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new PizzaWithBacon(pizzaOrder);
        pizzaOrder = new PizzaWithHam(pizzaOrder);
        pizzaOrder = new PizzaWithPineapple(pizzaOrder);
        //When
        String description = pizzaOrder.getDescription();
        //Then
        System.out.println("Pizza with bacon, ham and pineapple: " + description);
        assertEquals("Pizza, cheese and sos + bacon + ham + pineapple", description);
    }
}