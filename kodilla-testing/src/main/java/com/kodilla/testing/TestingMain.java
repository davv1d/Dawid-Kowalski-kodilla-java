package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        String name = "name";
        SimpleUser simpleUser = new SimpleUser(name);
        String resultName = simpleUser.getUsername();
        if (resultName.equals(name)) {
            System.out.println("test ok");
        } else {
            System.out.println("Error");
        }
        System.out.println("Test - pierwszy test jednostkowy:");
        Calculator calculator = new Calculator();
        int resultAdd = calculator.add(5, 2);
        if (resultAdd == 7) {
            System.out.println("Add test OK");
        } else {
            System.out.println("Add ERROR");
        }
        int resultSubstract = calculator.substract(10, 5);
        if (resultSubstract == 5) {
            System.out.println("Substract test OK");
        } else {
            System.out.println("Substract test ERROR");
        }
    }
}
