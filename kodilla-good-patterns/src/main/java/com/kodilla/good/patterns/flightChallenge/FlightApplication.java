package com.kodilla.good.patterns.flightChallenge;

import java.util.Set;

public class FlightApplication {
    public static void main(String[] args) {
        FlightRetriever flightRetriever = new FlightRetriever();
        FlightService flightService = new FlightService(flightRetriever.retrieve());
        Set<Flight> flightsFrom = flightService.findFlightsFrom("Warszawa");
        Set<Flight> flightsFromToThrough = flightService.findFlightsFromToThrough("Gdańsk", "Kraków", "Wrocław");
        Set<Flight> flightsTo = flightService.findFlightsTo("Kraków");
        System.out.println("Flights from");
        flightsFrom.forEach(System.out::println);
        System.out.println("Flights from to through");
        flightsFromToThrough.forEach(System.out::println);
        System.out.println("Flight to");
        flightsTo.forEach(System.out::println);

    }
}
