package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class MailInformationService implements InformationService {
    @Override
    public void inform(Client client, LocalDateTime send) {
        System.out.println("Ms./Mr."+ client.getName()+client.getSurname()+" Ordered product has been send "+send+".");
    }
}
