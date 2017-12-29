package com.kodilla.good.patterns.challenges;


public class OrderDto {
    public Client client;
    public boolean isSend;

    public OrderDto(Client client, boolean isSend) {
        this.client = client;
        this.isSend = isSend;
    }

    public Client getClient() {
        return client;
    }

    public boolean isSend() {
        return isSend;
    }
}
