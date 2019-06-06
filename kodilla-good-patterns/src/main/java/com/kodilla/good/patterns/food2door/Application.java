package com.kodilla.good.patterns.food2door;

public class Application {
    public static void main(String[] args) {
        CompanyAndOrderRetriever companyAndOrderRetriever = new CompanyAndOrderRetriever();
        FoodDto retriever = companyAndOrderRetriever.retriever();
        Food2DoorCompany food2DoorCompany = retriever.getFood2DoorCompany();
        food2DoorCompany.doOrder(retriever.getOrder());
    }
}
