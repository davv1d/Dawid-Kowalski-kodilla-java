package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public final class World {
    private final Set<Continent> theContinentSet = new HashSet<>();

    public void addContinent(Continent continent) {
        theContinentSet.add(continent);
    }

    public boolean removeContinent(Continent continent) {
        return theContinentSet.remove(continent);
    }

    public BigDecimal getPeopleQuantity() {
        return theContinentSet.stream()
                .flatMap(continent -> continent.getTheCountrySet().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum.add(current));
    }
}
