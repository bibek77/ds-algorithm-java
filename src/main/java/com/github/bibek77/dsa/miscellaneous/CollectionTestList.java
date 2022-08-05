package com.github.bibek77.dsa.miscellaneous;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bibek
 */
public class CollectionTestList {
    // Verifying that ArrayList with Initial Capacity is faster when size increases.

    public static void main(String[] args) {
        System.out.println("Response time with Initial Capacity (in ms) : " + checkWithCapacity());
        System.out.println("Response time without Initial Capacity (in ms) : " + checkWithoutCapacity());
        System.out.println("Linked List Insertion Stats in Beginning : " +  linkedListInsertionStats());
        System.out.println("Array List Insertion Stats in Beginning : " +  arrayListInsertionStats());

    }

    private static long checkWithCapacity() {
        long startTime = System.currentTimeMillis();
        List<Integer> numList = new ArrayList<>(60000000);
        int i=0;
        while(i++<60000000) {
            int val = (int) (i* Math.random());
            numList.add(val);
        }
        long resTime = System.currentTimeMillis() - startTime;
        return resTime;
    }

    private static long checkWithoutCapacity() {
        long startTime = System.currentTimeMillis();
        List<Integer> numList2 = new ArrayList<>();
        int i=0;
        while(i++<60000000) {
            int val = (int) (i* Math.random());
            numList2.add(val);
        }
        long resTime = System.currentTimeMillis() - startTime;
        return resTime;
    }

    private static long linkedListInsertionStats() {
        long startTime = System.currentTimeMillis();
        List<Integer> numList = new LinkedList<>();
        int i=0;
        while(i++<100000) {
            int val = (int) (i* Math.random());
            numList.add(numList.size()/2,val);
        }
        long resTime = System.currentTimeMillis() - startTime;
        return resTime;
    }

    private static long arrayListInsertionStats() {
        long startTime = System.currentTimeMillis();
        List<Integer> numList = new LinkedList<>();
        int i=0;
        while(i++<100000) {
            int val = (int) (i* Math.random());
            numList.add(numList.size()/2, val);
        }
        long resTime = System.currentTimeMillis() - startTime;
        return resTime;
    }
}
