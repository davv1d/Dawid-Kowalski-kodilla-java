package com.kodilla.good.patterns.food2door;

public class HealthyShop implements Producer{
    private KindOfProduct kindOfProduct = KindOfProduct.HEALTHY_FOOD;
    private int amountOfProduct = 1000;

    @Override
    public KindOfProduct getKindOfProduct() {
        return kindOfProduct;
    }

    @Override
    public int amountOfProduct() {
        return amountOfProduct;
    }

    @Override
    public boolean process(Order order) {
        System.out.println("We realize your order");
        amountOfProduct -= order.getAmountOfProduct();
        System.out.println("Everything is ok");
        return true;

    }
}
