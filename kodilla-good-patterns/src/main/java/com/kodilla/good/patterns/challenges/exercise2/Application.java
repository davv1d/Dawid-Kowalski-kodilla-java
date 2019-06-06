package com.kodilla.good.patterns.challenges.exercise2;

public class Application {
    public static void main(String[] args) {
        RentRequestRetriever rentRequestRetriever = new RentRequestRetriever();
        RentRequest rentRequest = rentRequestRetriever.retrieve();
        ProductOrderService productOrderService = new ProductOrderService(new PhoneInformation(), new Allegro(),new AllegroDatabase());
        productOrderService.process(rentRequest);
    }
}
