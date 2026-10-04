package com.github.bibek77.dsa.designPrinciples.ocp2;

/**
 * @author bibek
 */
public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        PaymentMethod creditCard = new CreditCard();
        PaymentMethod debitCard = new DebitCard();

        paymentProcessor.processPayment(debitCard, 200);
    }
}
