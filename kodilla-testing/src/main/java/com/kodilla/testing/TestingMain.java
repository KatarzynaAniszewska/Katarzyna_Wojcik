package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;

import com.kodilla.testing.Calculator;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
        Calculator simpleCalculator = new Calculator();
        int addResult = simpleCalculator.addAtoB(500,2633);
        int substractResult = simpleCalculator.subtractAfromB(546,8569);
        System.out.println(addResult);
        System.out.println(substractResult);
    }
}
