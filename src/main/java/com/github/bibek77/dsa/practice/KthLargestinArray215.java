package com.github.bibek77.dsa.practice;

/**
 * @author bibek
 */
public class KthLargestinArray215 {
    public static void main(String[] args) {
        int[] ar = {1, 4, 3, 40, 12, 8, 7, 34, 20};
        System.out.println(findKthLargest(ar, 2));
    }

    public static int findKthLargest(int[] nums, int k) {

//        quickSort(nums, 0, nums.length - 1);
//        return nums[nums.length - k];
        quickSelect(nums, 0, nums.length - 1, nums.length - k);
        return nums[nums.length - k];


    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = end;
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] < arr[pivot]) {
                i += 1;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, pivot);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // QuickSelect algo to find the kth using pivot
    public static int quickSelect(int[] arr, int start, int end, int k) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            if (pivot == k)
                return arr[pivot];
            else if (k < pivot)
                quickSelect(arr, start, pivot - 1, k);
            else
                quickSelect(arr, pivot + 1, end, k);
        }
        return 0;
    }
}
