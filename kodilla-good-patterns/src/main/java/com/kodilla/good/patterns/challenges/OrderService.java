package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public interface OrderService {
    boolean prepareOrder (Client client, LocalDateTime paid, LocalDateTime sent);
}
