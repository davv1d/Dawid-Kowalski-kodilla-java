package com.kodilla.good.patterns.food2door;

public interface Producer {
    KindOfProduct getKindOfProduct();
    int amountOfProduct();
    boolean process(Order order);
}
