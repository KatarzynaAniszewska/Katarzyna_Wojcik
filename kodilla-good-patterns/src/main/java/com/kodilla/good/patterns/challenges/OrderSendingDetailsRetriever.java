package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderSendingDetailsRetriever {
    public OrderSendingDetails retrieve(){
        Client client = new Client("John","Smith");
        LocalDateTime paid = LocalDateTime.of(2017,12,15,12,30);
        LocalDateTime send = LocalDateTime.of(2017,12,20,8,13);
        return new OrderSendingDetails(client,paid,send);
    }
}