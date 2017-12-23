package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindFlight {


    public Boolean[] findFlight(Flight flight) throws RouteNotFoundException {
// implementacja Hashmapy
        Map<String, Boolean> airportAvailability = new HashMap<>();
        airportAvailability.put("Warsaw",true);
        airportAvailability.put("London",true);
        airportAvailability.put("New York",false);

        if ((airportAvailability.get(flight.getArrivalAirport())!= null
                &&airportAvailability.get(flight.getDepartureAirport()))) {
            Boolean[] result = new Boolean[2];
            result[0] = airportAvailability.get(flight.getArrivalAirport());
            result[1] = airportAvailability.get(flight.getDepartureAirport());
            return result;
        }
        throw new RouteNotFoundException("Route not found");
    }
}