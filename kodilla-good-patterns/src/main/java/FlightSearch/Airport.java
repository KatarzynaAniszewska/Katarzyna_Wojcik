package FlightSearch;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Airport {
    String cityName;
    Set<Airport> arrivalAirports = new HashSet<>();
    Set<Set<Airport>> departureAirports = new HashSet<>();

    public Airport(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public Set<Airport> getArrivalAirports() {
        return arrivalAirports;
    }

    public void addArrivalAirport(Airport airport) {
        arrivalAirports.add(airport);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        if (!cityName.equals(airport.cityName)) return false;
        return arrivalAirports.equals(airport.arrivalAirports);
    }

    @Override
    public int hashCode() {
        return cityName.hashCode();

    }

    @Override
    public String toString() {
        return "Airport{" +
                "cityName='" + cityName + '\'' +
                '}';
    }

    public Set<String> getArrivalCityDirectFlight(String cityName) {
        return arrivalAirports.stream()
                .map(Airport::getCityName)
                .collect(Collectors.toSet());


    }


    public Set<String> getArrivalCityTransferFlight(String cityName) {
        return arrivalAirports.stream()
                .flatMap(airport -> airport.getArrivalAirports().stream())
                .filter(airport -> airport != this)
                .map(Airport::getCityName)
                .collect(Collectors.toSet());
    }
}