package com.github.bibek77.dsa.dataStructures.sorting;

/**
 * @author bibek
 */
public class QuickSort {
    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }

    }

    public int partition(int[] arr, int start, int end) {
        int pivot = end;
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] < arr[pivot]) {
                i += 1;
                swap(arr, i, j);
            }
        }
        // pivot element to be swapped with next ith element
        // return next ith as pivot
        swap(arr, i + 1, pivot);
        return i + 1;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
