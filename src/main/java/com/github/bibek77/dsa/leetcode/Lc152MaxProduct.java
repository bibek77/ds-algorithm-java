package com.github.bibek77.dsa.leetcode;

/**
 * @author bibek
 */
public class Lc152MaxProduct {
    static class Solution {
        public int maxProduct(int[] nums) {
            int n = nums.length;

            // Track the running product from left to right
            int leftProd = 1;
            // Track the running product from right to left
            int rightProd = 1;

            // Initialize maxProd to the smallest possible integer
            // to ensure any product we find will be larger than the initial value
            int maxProd = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                // ZERO HANDLING:
                // A zero will multiply everything after it by zero, destroying the product.
                // When we hit a zero, we reset the running product back to 1.
                // This effectively abandons the old subarray and starts a new one.
                leftProd = leftProd == 0 ? 1 : leftProd;
                rightProd = rightProd == 0 ? 1 : rightProd;

                // PREFIX PRODUCT: Multiply the current element from the left
                leftProd *= nums[i];

                // SUFFIX PRODUCT: Multiply the current element from the right.
                // As 'i' goes up, (n - 1 - i) goes down, reading the array backwards.
                rightProd *= nums[n - 1 - i];

                // UPDATE RECORD:
                // The maximum product subarray could be found scanning from the left,
                // or scanning from the right. We check both against our current record.
                maxProd = Math.max(maxProd, Math.max(leftProd, rightProd));
            }

            return maxProd;
        }
    }
}
