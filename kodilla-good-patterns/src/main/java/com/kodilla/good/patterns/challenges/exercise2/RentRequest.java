package com.kodilla.good.patterns.challenges.exercise2;

import java.time.LocalDateTime;

public class RentRequest {
    private User user;
    private LocalDateTime from;
    private LocalDateTime to;
    private Thing thing;

    public RentRequest(User user, LocalDateTime from, LocalDateTime to, Thing thing) {
        this.user = user;
        this.from = from;
        this.to = to;
        this.thing = thing;
    }

    public Thing getThing() {
        return thing;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }
}
