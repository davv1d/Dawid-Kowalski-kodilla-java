package com.kodilla.good.patterns.food2door;

public class ExtraFoodShop implements Producer {
    private KindOfProduct kindOfProduct = KindOfProduct.EXTRA_FOOD;
    private int amountOfProduct = 1000;

    @Override
    public KindOfProduct getKindOfProduct() {
        return kindOfProduct;
    }

    @Override
    public int amountOfProduct() {
        return 1000;
    }

    @Override
    public boolean process(Order order) {
        System.out.println("I call to my boss");
        amountOfProduct -= order.getAmountOfProduct();
        return true;

    }
}
