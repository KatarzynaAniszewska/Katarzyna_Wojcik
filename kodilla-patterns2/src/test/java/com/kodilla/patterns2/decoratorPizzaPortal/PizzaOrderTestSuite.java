package com.kodilla.patterns2.decoratorPizzaPortal;

import com.kodilla.patterns2.dacorator.pizza.BasicPizzaOrder;
import com.kodilla.patterns2.dacorator.pizza.ExtraCheeseDecorator;
import com.kodilla.patterns2.dacorator.pizza.PizzaOrder;
import com.kodilla.patterns2.dacorator.pizza.SausageDecorator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

public class PizzaOrderTestSuite {
    @Test
    public void testExtraCheeseWithSausageCost(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new SausageDecorator(pizzaOrder);
        //When
        BigDecimal pizzaCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(28),pizzaCost);
    }
    @Test
    public void testExtraCheeseWithSausageDescription(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new SausageDecorator(pizzaOrder);
        //When
        String  pizzaDescription = pizzaOrder.getDescription();
        //Then
        assertEquals("Base and tomato sauce extra cheese sausage",pizzaDescription);
    }
}
