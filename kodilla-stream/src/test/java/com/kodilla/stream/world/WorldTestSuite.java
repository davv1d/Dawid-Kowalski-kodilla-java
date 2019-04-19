package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        Country germany = new Country(new BigDecimal("82790000"), "Germany");
        Country poland = new Country(new BigDecimal("38430000"), "Poland");
        Country china = new Country(new BigDecimal("1386000000"), "China");
        Country india = new Country(new BigDecimal("1340000000"), "India");
        Country canada = new Country(new BigDecimal("37000000"), "Canada");
        Country usa = new Country(new BigDecimal("327200000"), "USA");
        Continent europe = new Continent("Europe");
        europe.addCountry(germany);
        europe.addCountry(poland);
        Continent northAmerica = new Continent("North America");
        northAmerica.addCountry(canada);
        northAmerica.addCountry(usa);
        Continent asia = new Continent("Asia");
        asia.addCountry(china);
        asia.addCountry(india);
        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(northAmerica);
        //When
        BigDecimal peopleQuantity = world.getPeopleQuantity();
        //Then
        BigDecimal expectetPeopleQuantity = new BigDecimal("3211420000");
        Assert.assertEquals(expectetPeopleQuantity, peopleQuantity);
    }
}
