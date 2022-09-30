package com.github.bibek77.dsa.dataStructures.sorting;

/**
 * @author bibek
 */
public class InsertionSort {
    public void insertionSort(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            int temp = ar[i], j=i;
            while(j>0 && ar[j-1]>temp) {
                ar[j] = ar[j-1];
                j--;
            }
            ar[j] = temp;
        }

    }
}
