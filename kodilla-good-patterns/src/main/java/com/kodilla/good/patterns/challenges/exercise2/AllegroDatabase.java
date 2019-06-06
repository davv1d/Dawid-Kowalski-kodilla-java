package com.kodilla.good.patterns.challenges.exercise2;

public class AllegroDatabase implements RentalRepository {

    @Override
    public void createRental(RentRequest rentRequest) {
        System.out.println("Connected to database");
        System.out.println("INSERT INTO Order (UserName, ThingName, from, to) " +
                "VALUES (" + rentRequest.getUser().getName() + ", "
                + rentRequest.getThing().getName() + ", "
                + rentRequest.getFrom() + ", "
                + rentRequest.getTo());
    }
}
