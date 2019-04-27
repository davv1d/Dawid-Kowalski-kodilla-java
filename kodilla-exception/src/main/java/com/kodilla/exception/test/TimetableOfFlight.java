package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class TimetableOfFlight {
    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> currentMap = createCurrentMap();
        if(!currentMap.containsKey(flight.getArrivalAirport())) {
            throw new RouteNotFoundException("Not found airport");
        }
        String s = currentMap.get(flight.getArrivalAirport()) ? "Flight is possible" : "Arrival airport is closed";
        System.out.println(s);
    }

    private Map<String, Boolean> createCurrentMap() {
        Map<String, Boolean> currentFlightsMap = new HashMap<>();
        currentFlightsMap.put("Contiguous United States", true);
        currentFlightsMap.put("Alaska", true);
        currentFlightsMap.put("Hawaii", false);
        currentFlightsMap.put("Warsaw Chopin Airport", true);
        currentFlightsMap.put("Katowice Airport", false);
        currentFlightsMap.put("Radom Airport", true);
        return currentFlightsMap;
    }
}
