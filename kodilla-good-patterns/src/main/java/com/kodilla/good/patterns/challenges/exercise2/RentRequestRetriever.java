package com.kodilla.good.patterns.challenges.exercise2;

import java.time.LocalDateTime;

public class RentRequestRetriever {
    public RentRequest retrieve(){
        User user = new User("will", 20);
        LocalDateTime rentFrom = LocalDateTime.of(2000, 8, 12, 12,0);
        LocalDateTime rentTo = LocalDateTime.of(2000, 10, 12, 12,0);
        Thing slippers = new Thing("slippers");
        return new RentRequest(user, rentFrom, rentTo, slippers);
    }
}
