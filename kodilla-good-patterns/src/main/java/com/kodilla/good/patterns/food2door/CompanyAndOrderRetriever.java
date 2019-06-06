package com.kodilla.good.patterns.food2door;

public class CompanyAndOrderRetriever {
    public FoodDto retriever(){
        Order order = new Order(5000, KindOfProduct.EXTRA_FOOD);
        Producer extraFoodShop = new ExtraFoodShop();
        Food2DoorCompany food2DoorCompany = new Food2DoorCompany();
        food2DoorCompany.addProducer(extraFoodShop);
        return new FoodDto(food2DoorCompany, order);
    }
}
