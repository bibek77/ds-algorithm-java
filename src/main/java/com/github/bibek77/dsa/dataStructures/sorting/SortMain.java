package com.github.bibek77.dsa.dataStructures.sorting;

import java.util.Arrays;

/**
 * @author bibek
 */
public class SortMain {
    public static void main(String[] args) {
        int[] ar = {1, 4, 3, 40, 12, 8, 7, 34, 20};
        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.bubbleSortIncrease(ar);
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(ar);
        System.out.println(Arrays.toString(ar));
    }
}
