package com.github.bibek77.dsa.dataStructures.search;

/**
 * @author bibek
 */
public class Search {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 40, 12, 8, 7, 34, 20};
        LinearSearch linearSearch = new LinearSearch();
        System.out.println("Found at position: " + linearSearch.search(arr, 40));
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(arr, 40));
    }
}
