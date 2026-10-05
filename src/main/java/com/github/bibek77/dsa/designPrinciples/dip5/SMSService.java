package com.github.bibek77.dsa.designPrinciples.dip5;

/**
 * @author bibek
 */
public class SMSService implements NotiticationChannel{
    @Override
    public void send(String msg) {
        System.out.println("Sends SMS " + msg);
    }
}
