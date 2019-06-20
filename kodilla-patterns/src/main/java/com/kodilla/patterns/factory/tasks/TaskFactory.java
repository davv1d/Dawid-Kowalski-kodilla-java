package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING_TASK = "SHOPPING_TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String DRIVING_TASK = "DRIVING_TASK";

    public final Task makeTask(String taskClass) {
        switch (taskClass) {
            case SHOPPING_TASK:
                return new ShoppingTask("Shopping", "door", 2);
            case PAINTING_TASK:
                return new PaintingTaks("Paint", "red", "car");
            case DRIVING_TASK:
                return new DrivingTask("Drive", "London", "train");
            default:
                return null;
        }
    }
}
