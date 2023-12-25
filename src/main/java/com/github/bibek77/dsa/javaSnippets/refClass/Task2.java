package com.github.bibek77.dsa.javaSnippets.refClass;

/**
 * @author bibek
 */
public class Task2 extends Thread {
    public void run() {
        go();
        System.out.println("Inside run t2 ...");
    }

    public void go() {
        System.out.println("Inside go t2 ...");
        more();
    }

    public void more() {
        System.out.println("Inside more t2 ...");
    }
}