package com.kodilla.good.patterns.flightChallenge;

public class Flight {
    private String startingAirport = "";
    private String landingAirport = "";
    private String flightThroughTheCity = "";

    public Flight(String startingAirport, String landingAirport, String flightThroughTheCity) {
        this.startingAirport = startingAirport;
        this.landingAirport = landingAirport;
        this.flightThroughTheCity = flightThroughTheCity;
    }

    public Flight(String startingAirport, String landingAirport) {
        this.startingAirport = startingAirport;
        this.landingAirport = landingAirport;
    }

    public String getStartingAirport() {
        return startingAirport;
    }

    public String getLandingAirport() {
        return landingAirport;
    }

    public String getFlightThroughTheCity() {
        return flightThroughTheCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (getStartingAirport() != null ? !getStartingAirport().equals(flight.getStartingAirport()) : flight.getStartingAirport() != null)
            return false;
        if (getLandingAirport() != null ? !getLandingAirport().equals(flight.getLandingAirport()) : flight.getLandingAirport() != null)
            return false;
        return getFlightThroughTheCity() != null ? getFlightThroughTheCity().equals(flight.getFlightThroughTheCity()) : flight.getFlightThroughTheCity() == null;

    }

    @Override
    public int hashCode() {
        int result = getStartingAirport() != null ? getStartingAirport().hashCode() : 0;
        result = 31 * result + (getLandingAirport() != null ? getLandingAirport().hashCode() : 0);
        result = 31 * result + (getFlightThroughTheCity() != null ? getFlightThroughTheCity().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String s = flightThroughTheCity.equals("") ? "" : " flight through " + flightThroughTheCity;
        return "Flight from " +
                startingAirport + " to " +
                landingAirport + s;
    }
}
