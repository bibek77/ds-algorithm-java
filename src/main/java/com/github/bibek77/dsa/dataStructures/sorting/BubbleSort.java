package com.github.bibek77.dsa.dataStructures.sorting;

/**
 * @author bibek
 */
public class BubbleSort {
    public void bubbleSortIncrease(int ar[]) {
        int len = ar.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (ar[i] > ar[j]) {
                    int temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                }
            }
        }
    }
}
