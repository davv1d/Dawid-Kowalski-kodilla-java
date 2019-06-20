package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {
    private final String name;
    private final String where;
    private final String using;
    private boolean isTaskExecuted;

    public DrivingTask(String name, String where, String using) {
        this.name = name;
        this.where = where;
        this.using = using;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void executeTask() {
        isTaskExecuted = true;
        System.out.println(name + " to: " + where + " using: " + using);
    }

    @Override
    public boolean isTaskExecuted() {
        return isTaskExecuted;
    }
}
