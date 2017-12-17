package com.kodilla.stream.world;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WorldTestSuite {
    Continent continent;

    public WorldTestSuite(Continent continent) {
        this.continent = continent;
    }

    @Test
    public void testGetPeopleQuanity(){


           //given

            Country country1 = new Country("Poland",new BigDecimal(40000000));
            Country country2 = new Country("France", new BigDecimal(85000233));
            Country country3 = new Country("Germany", new BigDecimal("90111233"));
            Country country4 = new Country("Brasil",new BigDecimal("110000000"));
            Country country5 = new Country("Peru",new BigDecimal("55000000"));
            Country country6 = new Country("Chile",new BigDecimal("21000000"));
            Country country7 = new Country("Russia",new BigDecimal("101000000"));
            Country country8 = new Country("India",new BigDecimal("99000000"));

            List<Country> europe = new ArrayList<>();
            europe.add(country1);
            europe.add(country2);
            europe.add(country3);
            List<Country> southAmerica = new ArrayList<>();
            southAmerica.add(country4);
            southAmerica.add(country5);
            southAmerica.add(country1);
            List<Country> asia = new ArrayList<>();
            asia.add(country7);
            asia.add(country8);


        }
    }

