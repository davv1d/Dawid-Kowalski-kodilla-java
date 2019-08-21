package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Student implements Observable {
    private final String name;
    private final List<Observer> observers;

    public Student(String name) {
        this.observers = new ArrayList<>();
        this.name = name;
    }

    public void submitExerciseForReview(String exercise) {
        notifyObservers(exercise);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(String exercise) {
        for (Observer observer: observers) {
            observer.update(name + ": Exercise: " + exercise);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
