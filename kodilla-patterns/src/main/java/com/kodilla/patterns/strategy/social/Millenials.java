package com.kodilla.patterns.strategy.social;

public class Millenials extends User {
    public Millenials(String name) {
        super(name);
        socialPublisher = new FacebookPublisher();
    }
}
