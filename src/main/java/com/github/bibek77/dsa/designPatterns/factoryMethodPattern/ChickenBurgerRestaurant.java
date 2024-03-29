package com.github.bibek77.dsa.designPatterns.factoryMethodPattern;

/**
 * @author bibek
 */
public class ChickenBurgerRestaurant extends Restaurant {
    @Override
    public Burger createBurger() {
        return new ChickenBurger();
    }
}
