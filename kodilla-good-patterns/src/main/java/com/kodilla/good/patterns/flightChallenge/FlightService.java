package com.kodilla.good.patterns.flightChallenge;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightService {
    private Set<Flight> allFlights;

    public FlightService(Set<Flight> allFlights) {
        this.allFlights = allFlights;
    }

    public Set<Flight> findFlightsFrom(String startingAirport) {
        return allFlights.stream()
                .filter(flight -> flight.getStartingAirport().equals(startingAirport))
                .collect(Collectors.toSet());
    }

    public Set<Flight> findFlightsTo(String landingAirport) {
        return allFlights.stream()
                .filter(flight -> flight.getLandingAirport().equals(landingAirport) ||
                        flight.getFlightThroughTheCity().equals(landingAirport))
                .collect(Collectors.toSet());
    }

    public Set<Flight> findFlightsFromToThrough(String startingAirport, String flightThroughTheCity, String landingAirport) {
        return allFlights.stream()
                .filter(flight -> flight.getStartingAirport().equals(startingAirport) &&
                        flight.getFlightThroughTheCity().equals(flightThroughTheCity) &&
                        flight.getLandingAirport().equals(landingAirport))
                .collect(Collectors.toSet());
    }

}
