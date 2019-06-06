package com.kodilla.good.patterns.challenges.exercise2;

public class RentalDto {
    private User user;
    private boolean isRent;

    public RentalDto(final User user,final boolean isRent) {
        this.user = user;
        this.isRent = isRent;
    }

    public User getUser() {
        return user;
    }

    public boolean isRent() {
        return isRent;
    }
}
