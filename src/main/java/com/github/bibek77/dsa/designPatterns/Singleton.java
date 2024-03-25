package com.github.bibek77.dsa.designPatterns;

/**
 * @author bibek
 * Creational Design Pattern
 * 1 - Singleton Pattern
 */
public class Singleton {
    private static volatile Singleton instance;
    private String data;

    private Singleton(String data) {
        this.data = data;
    }

    private static Singleton getInstance(String data) {
        // this method ensures we just create a single instance of the class.
        // And it provides just a single point of access to it.
        if (instance == null) { // This check is to limit using synchronized block which is an overhead
            synchronized (Singleton.class) { // synchronised ensures thread safe
                if (instance == null) { // check if instance is already created
                    instance = new Singleton(data); // create a new instance
                }
            }
        }
        return instance;
    }
}
