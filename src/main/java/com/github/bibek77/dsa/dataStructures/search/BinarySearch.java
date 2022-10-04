package com.github.bibek77.dsa.dataStructures.search;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author bibek
 */
public class BinarySearch {
    public int binarySearch(int[] arr, int value) {
        Arrays.sort(arr);
        int low = 0, high = arr.length - 1, mid = (low + high) / 2;
        while (arr[mid] != value && low <= high) {
            if (value < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }
        return arr[mid] == value ? mid : -1;
    }
}
