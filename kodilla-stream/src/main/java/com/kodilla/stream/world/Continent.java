package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.Set;

public final class Continent {
    private final Set<Country> theCountrySet = new HashSet<>();
    private final String name;

    public void addCountry(Country country) {
        theCountrySet.add(country);
    }

    public boolean removeCountry(Country country) {
        return theCountrySet.remove(country);
    }

    public Continent(String name) {
        this.name = name;
    }

    public Set<Country> getTheCountrySet() {
        return new HashSet<>(theCountrySet);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Continent continent = (Continent) o;

        return getName() != null ? getName().equals(continent.getName()) : continent.getName() == null;
    }
}
