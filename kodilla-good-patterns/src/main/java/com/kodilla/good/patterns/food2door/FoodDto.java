package com.kodilla.good.patterns.food2door;

public class FoodDto {
    private Food2DoorCompany food2DoorCompany;
    private Order order;

    public FoodDto(Food2DoorCompany food2DoorCompany, Order order) {
        this.food2DoorCompany = food2DoorCompany;
        this.order = order;
    }

    public Food2DoorCompany getFood2DoorCompany() {
        return food2DoorCompany;
    }

    public Order getOrder() {
        return order;
    }
}
