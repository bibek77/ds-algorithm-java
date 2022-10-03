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
//        selectionSort.selectionSort(ar);
        InsertionSort insertionSort = new InsertionSort();
//        insertionSort.insertionSort(ar);
        BucketSort bucketSort = new BucketSort();
//        bucketSort.bucketSort(ar);
        System.out.println(Arrays.toString(ar));
        MergeSort mergeSort = new MergeSort();
//        mergeSort.mergeSort(ar, 0, ar.length-1);
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(ar, 0, ar.length - 1);
        System.out.println(Arrays.toString(ar));
    }
}
