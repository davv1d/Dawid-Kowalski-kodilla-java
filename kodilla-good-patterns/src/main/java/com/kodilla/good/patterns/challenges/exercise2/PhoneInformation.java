package com.kodilla.good.patterns.challenges.exercise2;

public class PhoneInformation implements InformationService {
    @Override
    public void inform(User user, Thing thing) {
        System.out.println("SMS Message\nLady or gentleman " + user.getName() + ". You have a " + thing.getName());
    }
}
