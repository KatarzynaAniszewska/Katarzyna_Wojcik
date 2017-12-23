package com.kodilla.exception.test;

public class Flight {
    String departureAirport;
    String arrivalAirport;


    public Flight(String arrivalAirport, String departureAirport) {
        this.arrivalAirport = arrivalAirport;
        this.departureAirport=departureAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }
}
