package com.github.bibek77.dsa.designPrinciples.dip5;

/**
 * @author bibek
 */
public class Main {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService(new EmailService());
        notificationService.notify("Your order has been shipped.");

        NotificationService notificationService2 = new NotificationService(new SMSService());
        notificationService2.notify("OTP 12345");
    }
}
