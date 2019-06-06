package com.kodilla.good.patterns.flightChallenge;

import java.util.HashSet;
import java.util.Set;

public class FlightRetriever {
    public Set<Flight> retrieve(){
        Set<Flight> allFlights = new HashSet<>();
        Flight flight1 = new Flight("Warszawa", "Wrocław");
        Flight flight2 = new Flight("Gdańsk", "Wrocław");
        Flight flight3 = new Flight("Gdańsk", "Wrocław", "Kraków");
        Flight flight4 = new Flight("Warszawa", "Kraków");
        Flight flight5 = new Flight("Warszawa", "Kraków");
        allFlights.add(flight1);
        allFlights.add(flight2);
        allFlights.add(flight3);
        allFlights.add(flight4);
        allFlights.add(flight5);
        return allFlights;
    }
}
