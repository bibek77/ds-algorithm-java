package com.github.bibek77.dsa.designPrinciples.ocp2;

/**
 * @author bibek
 */
public class CreditCard implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Making payment via Credit card : " + amount);
        // can be any number of lines on how to implement this pay method
        // completely independent from other payment classes.
    }
}
