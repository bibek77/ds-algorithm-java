package com.github.bibek77.dsa.practice;

/**
 * @author bibek
 */
public class FirstLastSearchMatch34 {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;
        searchRange(arr, target);
    }

    public static int[] searchRange(int[] arr, int target) {
        int len = arr.length;
        if (len == 0)
            return new int[]{-1, -1};
        int low = 0, high = arr.length - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == target) {
                break;
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (arr[mid] != target)
            return new int[]{-1, -1};
        low = mid;
        high = mid;
        while (low >= 0 && arr[low] == target) {
            low--;
        }
        while (high < len && arr[high] == target) {
            high++;
        }
        return new int[]{low + 1, high - 1};

    }
}
