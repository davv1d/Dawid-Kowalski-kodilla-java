package com.kodilla.good.patterns.challenges.exercise2;

public class Allegro implements RentalService {

    @Override
    public boolean rent(RentRequest rentRequest) {
        if(rentRequest.getUser().getAge() >= 18) {
            System.out.println("The user " + rentRequest.getUser().getName() + " is of legal age, " +
                    rentRequest.getUser().getName() + " can rent " + rentRequest.getThing().getName());
            return true;
        } else {
            return false;
        }
    }
}
