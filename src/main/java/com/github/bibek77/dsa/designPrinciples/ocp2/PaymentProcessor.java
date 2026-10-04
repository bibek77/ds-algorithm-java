package com.github.bibek77.dsa.designPrinciples.ocp2;

/**
 * @author bibek
 */
public class PaymentProcessor {

    public void processPayment(PaymentMethod paymentMethod, double amount) {
       paymentMethod.pay(amount); // runtime polymorphism
        // follows open closed principle - open for extension closed for modification
    }
}
