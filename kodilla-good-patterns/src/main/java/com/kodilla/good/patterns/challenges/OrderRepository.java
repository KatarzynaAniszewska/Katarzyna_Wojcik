package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public interface OrderRepository {
    boolean createOrder(Client client, LocalDateTime paid,LocalDateTime send);
}
