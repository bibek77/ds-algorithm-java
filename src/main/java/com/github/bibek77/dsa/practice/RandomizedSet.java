package com.github.bibek77.dsa.practice;

import java.util.*;

/**
 * @author bibek
 */
class RandomizedSet {
    private final List<Integer> list;
    private final Map<Integer, List<Integer>> valueToIndex;
    private final Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        valueToIndex = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int value) {

        list.add(value);
        valueToIndex.computeIfAbsent(value, key -> new ArrayList<>()).add(list.size() - 1);
        return true;
    }

    public boolean remove(int value) {
        if (!valueToIndex.containsKey(value)) return false;

        List<Integer> indices = valueToIndex.get(value);
        int indexToRemove = indices.remove(indices.size() - 1);

// Since only an instance of the value is removed we can entirely remove it.
        if (indices.isEmpty()) {
            valueToIndex.remove(value);
        }

        int lastValue = list.get(list.size() - 1);
        List<Integer> lastValueIndices = valueToIndex.get(lastValue);
        lastValueIndices.remove(lastValueIndices.size() - 1);
        lastValueIndices.add(indexToRemove);

        list.set(indexToRemove, lastValue);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.insert(3));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.insert(7));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.getRandom());
    }

}
