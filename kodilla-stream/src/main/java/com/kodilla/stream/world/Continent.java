package com.kodilla.stream.world;
import java.util.ArrayList;
import java.util.List;


public final class Continent {
   private final Country country;
   private final List<Country> theContinent = new ArrayList<>();

    public Continent(Country country) {
        this.country = country;
    }

    public List<Country>getContinent(){
      theContinent.add(country);
      return theContinent;
   }

   public Country getCountry() {
      return country;
   }

   public List<Country> getTheContinent() {
      return theContinent;
   }
}
