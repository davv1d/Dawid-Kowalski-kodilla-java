package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {
    public ArrayList<Integer> exterminator(ArrayList<Integer> numbers) {
        ArrayList<Integer> evenNumbersList = new ArrayList<Integer>();
        numbers.forEach(number -> {
            if (number % 2 == 0)
                evenNumbersList.add(number);
        });
        return evenNumbersList;
    }
}
