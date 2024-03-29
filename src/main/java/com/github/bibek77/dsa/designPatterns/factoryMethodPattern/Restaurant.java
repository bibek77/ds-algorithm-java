package com.github.bibek77.dsa.designPatterns.factoryMethodPattern;

/**
 * @author bibek
 */
public abstract class Restaurant {
    // All the implementations are segregated into factory methods
    // So Design Principles SingleResponsibility and Open Closed Principle are followed
    // Now If any new Burger is to be added
    // It can extend its own Burger Factory Class and prepare burger
    // The aim is to segregate the construction of the Object & preparation of the Object
    public Burger orderBurger() {
        Burger burger = createBurger();
        burger.prepare();
        return burger;
    }

    public abstract Burger createBurger();
}
