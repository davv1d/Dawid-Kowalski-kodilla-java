package com.kodilla.good.patterns.food2door;

public class CompanyAndOrderRetriever {
    public FoodDto retriever(){
        Order order = new Order(500, KindOfProduct.HEALTHY_FOOD);
        Producer extraFoodShop = new ExtraFoodShop();
        Producer healthyShop = new HealthyShop();
        Food2DoorCompany food2DoorCompany = new Food2DoorCompany();
        food2DoorCompany.addProducer(extraFoodShop);
        food2DoorCompany.addProducer(healthyShop);
        return new FoodDto(food2DoorCompany, order);
    }
}
