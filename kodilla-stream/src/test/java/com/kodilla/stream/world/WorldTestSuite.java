package com.kodilla.stream.world;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuanity() {

        //given
        Country country1 = new Country("Poland", new BigDecimal(40000000));
        Country country2 = new Country("France", new BigDecimal(50000000));
        Country country3 = new Country("Germany", new BigDecimal(90000000));
        Country country4 = new Country("Brasil", new BigDecimal(100000000));
        Country country5 = new Country("Peru", new BigDecimal(50000000));
        Country country6 = new Country("Chile", new BigDecimal(210000000));
        Country country7 = new Country("Russia", new BigDecimal(100000000));
        Country country8 = new Country("India", new BigDecimal(100000000));

        Continent europe = new Continent();
        europe.addCountry(country1);
        europe.addCountry(country2);
        europe.addCountry(country3);
        Continent southAmerica = new Continent();
        southAmerica.addCountry(country4);
        southAmerica.addCountry(country5);
        southAmerica.addCountry(country6);
        Continent asia = new Continent();
        asia.addCountry(country7);
        asia.addCountry(country8);
        World world = new World();
        world.addContinent(europe);
        world.addContinent(southAmerica);
        world.addContinent(asia);
        //When
        BigDecimal totalNumberOfPeople = world.getPeopleQuantity();
        Assert.assertEquals(new BigDecimal(740000000), totalNumberOfPeople);
    }

}



