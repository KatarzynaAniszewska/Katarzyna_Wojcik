package com.kodilla.stream;


import com.kodilla.stream.world.Continent;
import com.kodilla.stream.world.Country;
import com.kodilla.stream.world.World;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StreamMain {
    public static void main(String[] args) {
        Country country1 = new Country("Poland", new BigDecimal(40000000));
        Country country2 = new Country("France", new BigDecimal(50000000));
        Country country3 = new Country("Germany", new BigDecimal("90000000"));
        Country country4 = new Country("Brasil", new BigDecimal("100000000"));
        Country country5 = new Country("Peru", new BigDecimal("50000000"));
        Country country6 = new Country("Chile", new BigDecimal("21000000"));
        Country country7 = new Country("Russia", new BigDecimal("100000000"));
        Country country8 = new Country("India", new BigDecimal("100000000"));

        List<Country> europe = new ArrayList<>();

        europe.add(country2);
        europe.add(country3);
        List<Country> southAmerica = new ArrayList<>();
        southAmerica.add(country4);
        southAmerica.add(country5);
        southAmerica.add(country1);
        List<Country> asia = new ArrayList<>();
        asia.add(country7);
        asia.add(country8);

        List<Continent> world = new ArrayList<>();
        world.add(new Continent(europe));
        world.add(new Continent(southAmerica));
        world.add(new Continent(asia));

        System.out.println(world);
    }
}






