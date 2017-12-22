package com.kodilla.exception.test;

public class ExeptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            secondChallenge.probablyIWillThrowException(3, 1.5);
        } catch (Exception e) {
            System.out.println("Incorrect argument value");
        } finally {
            {
                System.out.println("Program end.");
            }
        }
    }
}
