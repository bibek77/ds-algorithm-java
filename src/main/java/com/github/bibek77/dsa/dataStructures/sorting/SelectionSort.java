package com.github.bibek77.dsa.dataStructures.sorting;

/**
 * @author bibek
 */
public class SelectionSort {

    public void selectionSort(int[] ar) {
        for (int i = 0; i < ar.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[min] > ar[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = ar[min];
                ar[min] = ar[i];
                ar[i] = temp;
            }
        }
    }
}
