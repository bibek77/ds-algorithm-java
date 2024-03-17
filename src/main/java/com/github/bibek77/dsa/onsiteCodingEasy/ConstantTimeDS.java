package com.github.bibek77.dsa.onsiteCodingEasy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author bibek
 * Design a data structure that supports insert, delete, search and getRandom in constant time.
 * We assume the data structure to be designed is a set here.
 */
public class ConstantTimeDS {

    private static ArrayList<Integer> list;
    private static Map<Integer, Integer> map;
    private static Random random;

    public static void main(String[] args) {
        // Approach
        // We will use a combination of HashMap & ArrayList to perform all operations in a constant time.
        // instantiate the list & map objects
        init();
        insert(3);
        insert(12);
        insert(8);
        insert(9);
        insert(5);
        insert(34);

        System.out.println("Search : " + search(9));
        remove(9);
        System.out.println(search(9));
        System.out.println("Search : " + search(9));
        System.out.println(getRandom());
        System.out.println(getRandom());
        System.out.println(getRandom());
    }

    public static void init() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public static boolean insert(int n) {
        if (map.containsKey(n)) {
            return false;
        }
        // Data structure already has values, hence to prevent duplicate insertion.

        map.put(n, list.size()); // adding value to set & index position in list
        list.add(n);
        return true;
    }

    public static boolean remove(int n) {
        if (!map.containsKey(n)) {
            return false;
        }
        // Map does not contain the value hence we return false, as nothing to be removed.

        //Get the index of the element that is to be removed.
        //Get the last element from the list to replace it.
        int indexToBeRemoved = map.get(n);
        int lastValue = list.get(list.size() - 1);

        // Set the index to be removed with the last value picked.
        // And then remove the last index.
        list.set(indexToBeRemoved, lastValue);
        list.remove(list.size() - 1);

        // update last value's index since that was swapped
        // then remove n from map
        map.put(lastValue, indexToBeRemoved);
        map.remove(n);
        return true;
    }

    public static int search(int n) {
        // It gets the value of the key, i.e the index in constant time.
        if (map.containsKey(n)) {
            return map.get(n);
        }
        return -1;
    }

    public static int getRandom() {
        // in case list is empty we return -1;
        if (list.isEmpty())
            return -1;

        // It gets an index withing the max bound supplied.
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}
