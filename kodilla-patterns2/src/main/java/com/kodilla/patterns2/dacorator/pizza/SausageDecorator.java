package com.kodilla.patterns2.dacorator.pizza;

import java.math.BigDecimal;

public class SausageDecorator extends AbstractPizzaOrderDecorator {
    public SausageDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(8));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " sausage" ;
    }
}
