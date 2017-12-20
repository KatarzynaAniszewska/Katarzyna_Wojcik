package com.kodilla.stream.world;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class MyTests {
    public static void main(String[]args){
        LocalDate x =LocalDate.now().minusDays(6);
        int y;
        long u = DAYS.between(x, LocalDate.now());
        int w = Math.toIntExact(u);

        System.out.println(w);
    }
}

