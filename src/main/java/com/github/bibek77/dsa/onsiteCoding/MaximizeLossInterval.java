package com.github.bibek77.dsa.onsiteCoding;

import java.util.Stack;

/**
 * @author bibek
 * Given an array of stock prices, find the size of the widest interval over which the stock has lost value. Lost value is defined as the initial value of the interval is larger than the final value of the interval. Intermediate values within the interval may rise above the initial value, but the interval would still be considered as lost value.
 * <p>
 * Example :
 * Time: 00, 01, 02, 03, 04, 05, 06, 07, 08, 09, 10, 11, 12, 13, 14, 15, 16
 * Price: 50, 52, 58, 54, 57, 51, 55, 60, 62, 65, 68, 72, 62, 61, 59, 63, 72
 * <p>
 * Ans - 7
 * Explanation - the widest interval with a net loss in value is from the indices 07 to 14 and has length 14 - 7 = 7
 * Although a peak value of 72 at time index 11 is present in this interval, it is still considered an interval with loss value.
 */
public class MaximizeLossInterval {

    public static void main(String[] args) {
        int[] nums = {50, 52, 58, 54, 57, 51, 55, 60, 62, 65, 68, 72, 62, 61, 59, 63, 72};
        MaximizeLossInterval maximizeLossInterval = new MaximizeLossInterval();
        int result = maximizeLossInterval.maxLossInterval(nums);
        System.out.println(result);
    }

    public int maxLossInterval(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int maxInterval = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i); // push the index not the value as we have to calculate the interval
                // The smallest elements from the right is pushed to the stack.
            }
        }

        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                // if a greater element is encountered from the left then we pop from the stack and
                // get the interval.
                // the goal is to just get the maximum loss interval not the biggest loss
                int j = stack.pop();
                maxInterval = Math.max(maxInterval, j - i);
            }
        }
        return maxInterval;
    }
}
