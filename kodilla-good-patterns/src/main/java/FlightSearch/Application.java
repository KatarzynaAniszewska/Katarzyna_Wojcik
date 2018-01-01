 package FlightSearch;

public class Application {
public static void main (String []args){


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

    airport1.addDepartureAirport(airport1.getArrivalAirports());
    airport1.addDepartureAirport(airport2.getArrivalAirports());

//wszystkie loty bezpośrednie danego lotniska - a jak wyszukać z danego miasta ?
    System.out.println(airport1.getArrivalCityDirectFlight("Warszawa"));
    //wsszystkie loty z danego lotniska przez inne miasto
    System.out.println(airport1.getArrivalCityTransferFlight("Warszawa"));

    // wszystkie loty do danego miasta i tutaj nie wiem jak to rozwiąć

    System.out.println(airport1.getDeparture("Szczecin"));

}
}
