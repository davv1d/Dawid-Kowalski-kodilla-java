package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {
    private final BigDecimal peopleQuantity;
    private final String name;

    public Country(final BigDecimal peopleQuantity, final String name) {
        this.peopleQuantity = peopleQuantity;
        this.name = name;
    }

    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        return getName() != null ? getName().equals(country.getName()) : country.getName() == null;
    }
}
