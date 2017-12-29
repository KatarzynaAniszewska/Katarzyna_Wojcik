package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderSendingDetails {

public Client client;
public LocalDateTime paid;
public LocalDateTime send;

    public OrderSendingDetails(Client client, LocalDateTime paid, LocalDateTime send) {
        this.client = client;
        this.paid = paid;
        this.send = send;
    }

    public Client getClient() {
        return client;
    }

    public LocalDateTime getPaid() {
        return paid;
    }

    public LocalDateTime getSend() {
        return send;
    }
}
