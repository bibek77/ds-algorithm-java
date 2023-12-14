package com.github.bibek77.dsa.javaSnippets.refClass;

/**
 * @author bibek
 */
public class Task implements Runnable {

    @Override
    public void run() {
        go();
        System.out.println("Inside run t1 ...");
    }

    public void go() {
        System.out.println("Inside go t1 ...");
        more();
    }

    public void more() {
        System.out.println("Inside more t1...");
    }
}