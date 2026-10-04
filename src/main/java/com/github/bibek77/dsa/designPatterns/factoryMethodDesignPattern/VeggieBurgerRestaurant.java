package com.github.bibek77.dsa.designPatterns.factoryMethodDesignPattern;

/**
 * @author bibek
 */
public class VeggieBurgerRestaurant extends Restaurant{
    @Override
    public Burger createBurger() {
        return new VeggieBurger();
    }
}
