package com.github.bibek77.dsa.dataStructures.search;

/**
 * @author bibek
 */
public class LinearSearch {
    public int search(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i + 1;
            }
        }
        return -1;
    }
}
