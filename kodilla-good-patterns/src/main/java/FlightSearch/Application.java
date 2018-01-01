 package FlightSearch;

 import java.util.*;

 import java.util.stream.Collectors;
 import java.util.stream.Stream;

 public class Application {
     public static void main(String[] args) {


         Airport airport1 = new Airport("Warszawa");
         Airport airport2 = new Airport("Poznan");
         Airport airport3 = new Airport("Krakow");
         Airport airport4 = new Airport("Gdansk");
         Airport airport5 = new Airport("Szczecin");
         Airport airport6 = new Airport("Katowice");

         airport1.addArrivalAirport(airport2);
         airport1.addArrivalAirport(airport3);
         airport1.addArrivalAirport(airport6);

         airport2.addArrivalAirport(airport4);
         airport2.addArrivalAirport(airport5);
         airport2.addArrivalAirport(airport1);
         airport2.addArrivalAirport(airport5);


         System.out.println(airport1.getArrivalCityDirectFlight("Warszawa"));

         System.out.println(airport1.getArrivalCityTransferFlight("Warszawa"));

         List<Airport> allAirports = new ArrayList<>();
         allAirports.add(airport1);
         allAirports.add(airport2);
         allAirports.add(airport3);
         allAirports.add(airport4);
         allAirports.add(airport5);
         allAirports.add(airport6);
         List<Airport> airportToGetToWarszawa = allAirports.stream()
                 .filter(a -> a.getArrivalAirports().contains(airport1))
                 .collect(Collectors.toList());

         System.out.println(airportToGetToWarszawa);
     }
 }
