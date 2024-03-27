package com.github.bibek77.dsa.onsiteCodingEasy;

/**
 * @author bibek
 * Bitonic Sequence - A sequence that strictly increases and then decreases or vice versa.
 * Example - {1, 3, 5, 7, 9, 8, 6, 4, 2};
 * For this question we will consider strictly increases and then decreases.
 * Given a bitonic sequence find the max and min element in that sequence.
 */
public class BitonicMaxMin {
    public static void main(String[] args) {

        // Approach
        // We will use binary search to find the peak element at first.
        // Then find and return the min element comparing the bounds on both sides.
        // Return the peak element as the max element.
        int[] nums = {1, 3, 5, 7, 9, 8, 6, 4, 2};
        BitonicMaxMin bitonicMaxMin = new BitonicMaxMin();
        int[] result = bitonicMaxMin.bionicMaxMin(nums);
        System.out.println("Min : " + result[0] + ", Max : " + result[1]);
    }

    public int[] bionicMaxMin(int[] nums) {
        int[] result = new int[2];
        int peakIndex = getPeakIndex(nums);
        int max = getMaxElement(nums, peakIndex);
        int min = getMinElement(nums, peakIndex);
        result[0] = min;
        result[1] = max;
        return result;
    }

    public int getMinElement(int[] nums, int peakIndex) {
        if (nums[0] < nums[nums.length - 1])
            return nums[0];
        else return nums[1];
    }

    public int getMaxElement(int[] nums, int peakIndex) {
        return nums[peakIndex];
    }

    public int getPeakIndex(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > 0 && mid < n - 1) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid - 1] > nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (mid == 0) {
                if (nums[0] > nums[1]) return nums[0];
                else return nums[1];
            } else if (mid == n - 1) {
                if (nums[n - 1] > nums[n - 2]) return nums[n - 1];
                else return nums[n - 2];
            }
        }
        return -1;
    }
}
