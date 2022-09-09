package com.github.bibek77.dsa.practice;

import java.util.Arrays;

/**
 * @author bibek
 */
public class TwoSum {
    //Get index values of two numbers that sums to the target value
    public static void main(String[] args) {
        int arr[] = {1, 2, 7, 9, 3};
        int target = 12;
        int res[] = twoSumBrute(arr, target);
        System.out.println(res[0] + " " + res[1]);
    }

    //Brute Force Way
    public static int[] twoSumBrute(int arr[], int target) {

        int arrayLength = arr.length;
        int result[] = {-1, -1};
        if (arrayLength == 0 || arrayLength == 1)
            return result;
        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = i + 1; j < arrayLength; j++) {
                if (arr[i] + arr[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

}
