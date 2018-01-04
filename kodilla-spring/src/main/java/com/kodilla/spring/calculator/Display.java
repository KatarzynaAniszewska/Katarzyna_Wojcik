package com.kodilla.spring.calculator;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
public class Display {

    public void displayValue(double val){
        System.out.println(val);

    }
}
