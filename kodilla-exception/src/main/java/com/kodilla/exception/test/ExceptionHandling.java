package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            secondChallenge.probablyIWillThrowException(2,1);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            System.out.println("End");
        }
    }
}
