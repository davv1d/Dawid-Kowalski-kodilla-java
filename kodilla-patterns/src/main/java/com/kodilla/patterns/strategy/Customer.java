package com.kodilla.patterns.strategy;

public class Customer {
    final private String name;
    protected BuyPredictor buyPredictor;

    public Customer(String name) {
        this.name = name;
    }

    public void setBuyingStrategy(BuyPredictor buyPredictor) {
        this.buyPredictor = buyPredictor;
    }

    public String getName() {
        return name;
    }

    public String predict() {
        return buyPredictor.predictWhatToBuy();
    }
}
