package com.github.bibek77.dsa.javaSnippets.refClass;

import java.util.List;
import java.util.Map;

/**
 * @author bibek
 */
public class Dish {
    private final String name;
    private final boolean vegeterian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegeterian, int calories, Type type) {
        this.name = name;
        this.vegeterian = vegeterian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegeterian() {
        return vegeterian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                '}';
    }

    public enum Type {MEAT, FISH, OTHER}

    public enum CaloricLevel {DIET, NORMAL, FAT}
}
