package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {
    private final String name;
    private final String whatToBuy;
    private final double quantity;
    private boolean isTaskExecuted;

    public ShoppingTask(String name, String whatToBuy, double quantity) {
        this.name = name;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
        isTaskExecuted = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void executeTask() {
        isTaskExecuted = true;
        System.out.println(name + " buy: " + whatToBuy + " quantity: " + quantity);
    }

    @Override
    public boolean isTaskExecuted() {
        return isTaskExecuted;
    }
}
