package com.kodilla.stream.world;
import java.util.ArrayList;
import java.util.List;


public final class Continent {

   private List<Country> countryList = new ArrayList<>();

    public Continent(List<Country> europe) {
    }

    public List<Country>addCountry(Country country){
      countryList.add(country);
      return countryList;
   }

   public List<Country> getCountryList() {
      return countryList;
   }
}
