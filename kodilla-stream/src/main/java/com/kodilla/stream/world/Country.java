package com.kodilla.stream.world;

import java.math.BigDecimal;


public final class Country {
    private final String name;
    private BigDecimal numberOfPeople;



    public Country(final String name, BigDecimal numberOfPeople) {
        this.name = name;
        this.numberOfPeople = numberOfPeople;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getNumberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", numberOfPeople=" + numberOfPeople +
                '}';
    }


}
