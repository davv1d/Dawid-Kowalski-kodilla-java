package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Mentor implements Observer {
    private final String name;
    private final List<String> exercises;

    public Mentor(String name) {
        exercises = new ArrayList<>();
        this.name = name;
    }

    @Override
    public void update(String studentAndHisExercise) {
        exercises.add(studentAndHisExercise);
    }

    public int theNumberOfExercisesToCheck() {
        System.out.println("Mentor " + name);
        exercises.forEach(System.out::println);
        return exercises.size();
    }
}
