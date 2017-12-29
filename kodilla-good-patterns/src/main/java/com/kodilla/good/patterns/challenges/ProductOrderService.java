package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProductOrderService implements OrderService {

    @Override
    public boolean prepareOrder(Client client, LocalDateTime paid, LocalDateTime sent) {
        System.out.println("Details of order "+client.toString()+"date of payment, "+paid+
                ", order was sent "+sent);
        return true;
    }
}
