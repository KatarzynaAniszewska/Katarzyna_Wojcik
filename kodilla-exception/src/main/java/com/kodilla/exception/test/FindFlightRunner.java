package com.kodilla.exception.test;

public class FindFlightRunner {
    public static void main(String[]args)  {

        Flight flight = new Flight("Chicago","Warsaw");
        FindFlight findFlight = new FindFlight();
        try{ Boolean[] airportAvailable = findFlight.findFlight(flight);
            System.out.println(flight.getArrivalAirport() +" available: " +airportAvailable[0]);
            System.out.println(flight.getDepartureAirport() +" available: "+ airportAvailable[1]);
        }catch (RouteNotFoundException e){
            System.out.println("Route not found");
        }
        finally {System.out.println("That's all");}

    }
}