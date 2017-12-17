package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class World {

    private final Continent continent;

    public World(Continent continent) {
        this.continent = continent;
    }

private final List<Continent> world = new ArrayList<>();

    public List<Continent> getWorld() {
        return world;
    }

    public List<Continent> getContinent() {
        world.add(continent);
        return world;
    }
    public BigDecimal getPeopleQuantity(){
        return world.stream()
                .flatMap(c->c.getTheContinent().stream())
                .map(country -> country.getNumberOfPeople())//lub reference Country::getNumberOfPeople
                .reduce(BigDecimal.ZERO,(sum,current)->sum=sum.add(current));

    }
}
