package com.github.bibek77.dsa.javaSnippets;

import com.github.bibek77.dsa.javaSnippets.refClass.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author bibek
 */
public class StreamsAPIDish {

    public static void main(String[] args) {
        List<Dish> menu = getDishMenu();

        Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));
        dishesByType.forEach((key, value) -> System.out.println(key + " " + value));

        //Grouping
        Map<Dish.CaloricLevel, List<Dish>> dishByCaloricLevel = menu.stream()
                .collect(Collectors.groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                    else return Dish.CaloricLevel.FAT;
                }));
        for (Map.Entry<Dish.CaloricLevel, List<Dish>> entry : dishByCaloricLevel.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        //MultiLevel Grouping
        Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(Collectors.groupingBy(
                Dish::getType,
                Collectors.groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
                    else return Dish.CaloricLevel.FAT;
                })
        ));

        for (Map.Entry<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> entry : dishesByTypeCaloricLevel.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

    private static List<Dish> getDishMenu() {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("fries", true, 510, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );
        return menu;
    }
}
