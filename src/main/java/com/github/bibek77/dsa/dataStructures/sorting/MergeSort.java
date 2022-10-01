package com.github.bibek77.dsa.dataStructures.sorting;

/**
 * @author bibek
 */
public class MergeSort {
    public void mergeSort(int[] arr, int left, int right) {
        if (right > left) {
            int m = (left + right) / 2;
            mergeSort(arr, left, m);
            mergeSort(arr, m + 1, right);
            merge(arr, left, right, m);
        }
    }

    public void merge(int[] arr, int left, int right, int middle) {
        int[] leftArr = new int[middle - left + 2];
        int[] rightArr = new int[right - middle + 1];
        for (int i = 0; i <= middle - left; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < right - middle; i++) {
            rightArr[i] = arr[middle + 1 + i];
        }
        leftArr[(middle - left) + 1] = Integer.MAX_VALUE;
        rightArr[right - middle] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = left; k <= right; k++) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
        }
    }

}
