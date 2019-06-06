package com.kodilla.good.patterns.food2door;

public class Order {
    private int amountOfProduct;
    private KindOfProduct kindOfProduct;

    public Order(int amountOfProduct, KindOfProduct kindOfProduct) {
        this.amountOfProduct = amountOfProduct;
        this.kindOfProduct = kindOfProduct;
    }

    public int getAmountOfProduct() {
        return amountOfProduct;
    }

    public KindOfProduct getKindOfProduct() {
        return kindOfProduct;
    }
}
