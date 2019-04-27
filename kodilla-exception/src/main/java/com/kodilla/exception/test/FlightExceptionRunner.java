package com.kodilla.exception.test;

public class FlightExceptionRunner {
    //
    public static void main(String[] args) {
        Flight flight = new Flight("Aberdeen", "Bristol");
        TimetableOfFlight timetableOfFlight = new TimetableOfFlight();
        try {
            timetableOfFlight.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
