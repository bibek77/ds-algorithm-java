package com.github.bibek77.dsa.designPrinciples.ocp2;

/**
 * @author bibek
 */
public class Paypal implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Making payment via Paypal");
    }
}
