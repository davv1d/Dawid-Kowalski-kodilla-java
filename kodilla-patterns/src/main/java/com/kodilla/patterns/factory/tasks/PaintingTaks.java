package com.kodilla.patterns.factory.tasks;

public class PaintingTaks implements Task {
    private final String name;
    private final String color;
    private final String whatToPaint;
    private boolean isTaksExecuted;

    public PaintingTaks(String name, String color, String whatToPaint) {
        this.name = name;
        this.color = color;
        this.whatToPaint = whatToPaint;
        isTaksExecuted = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void executeTask() {
        isTaksExecuted = true;
        System.out.println(name + " paint: " + whatToPaint + " color: " + color);
    }

    @Override
    public boolean isTaskExecuted() {
        return isTaksExecuted;
    }
}
