package com.kodilla.testing;

<<<<<<< HEAD
import com.kodilla.testing.user.SimpleUser;
=======
public class TestingMain {
    public static void main(String []args){
        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");
    }

>>>>>>> ed9c1e1cc165775187c8b8813f1f4b96cba76236

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
