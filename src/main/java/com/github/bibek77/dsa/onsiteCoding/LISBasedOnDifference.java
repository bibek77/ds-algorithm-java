package com.github.bibek77.dsa.onsiteCoding;

import java.util.Arrays;

/**
 * @author bibek
 * Find the length of longest increasing subsequence such that the difference between consecutive elements in LIS is an increasing sequence
 * Example :
 * nums -> 1 2 3 4 5 6 ans -> 3
 * Explanation : the best LIS can be gotten if we take 1 , 2 , 4 ( in this way )
 */
public class LISBasedOnDifference {
    // Longest Increasing Subsequence based on difference
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        LISBasedOnDifference lisBasedOnDifference = new LISBasedOnDifference();
        int n = lisBasedOnDifference.longestIncreasingSubsequenceDifference(nums);
        System.out.println(n);
    }

    public int longestIncreasingSubsequenceDifference(int[] nums) {
        int n = nums.length;
        // Its given that the sequence is an increasing one
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        // minimum length is at least 1
        int maxLen = 0;
//      Implementation to be done
        return maxLen;
    }
}
