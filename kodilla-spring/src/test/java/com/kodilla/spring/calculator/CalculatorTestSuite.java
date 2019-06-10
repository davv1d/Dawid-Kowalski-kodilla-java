package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = (Calculator) context.getBean("calculator");
        //When
        double add = calculator.add(2, 5.6);
        double sub = calculator.sub(5.2, 1.1);
        double mul = calculator.mul(0.2, 10);
        double div = calculator.div(4, 2);
        //Then
        Assert.assertEquals(7.6, add, 0.01);
        Assert.assertEquals(4.1, sub, 0.01);
        Assert.assertEquals(2, mul, 0.01);
        Assert.assertEquals(2, div, 0.01);
    }
}
