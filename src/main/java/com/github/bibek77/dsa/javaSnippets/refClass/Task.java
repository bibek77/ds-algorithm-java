package com.github.bibek77.dsa.javaSnippets.refClass;

/**
 * @author bibek
 */
public class Task implements Runnable {

    @Override
    public void run() {
        go();
        System.out.println("Inside run ...");
    }

    public void go() {
        System.out.println("Inside go ...");
        more();
    }

    public void more() {
        System.out.println("Inside more ...");
    }
}