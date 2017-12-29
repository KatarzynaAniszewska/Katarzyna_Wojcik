package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class ProductsOrdersRepository implements OrderRepository {
    @Override
    public boolean createOrder(Client client, LocalDateTime paid, LocalDateTime send) {
        System.out.println("Order -"+client +" date of payment "+ paid+" date of sending" +send);
        return true;
    }
}
