package com.github.bibek77.dsa.onsiteCoding;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author bibek
 * There is a stream of integers. Every time you see a new element in the stream, return the mean value of the last N elements, excluding the largest K elements.
 * Example:
 * N=5
 * K=2
 * elements so far = [20, 2, -2, 0, 10, 1, 5, -2, 0]
 * last N elements: [10, 1, 5, -2, 0] largest K elements: [10, 5]
 * result = (1+(-2)+0)/3 = -0.3333333
 */
public class IntegerStream {
    public static void main(String[] args) {
        int[] nums = {20, 2, -2, 0, 10, 1, 5, -2, 0};
        int n = 5;
        int k = 2;
        IntegerStream integerStream = new IntegerStream();
        System.out.println("Result Mean : " + integerStream.meanValue(nums, n, k));
    }

    public double meanValue(int[] nums, int n, int k) {
        double result;
        int len = nums.length;
        int sum = 0;
        int x = 0, y = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = len - 1; i >= 0 && i >= len - n; i--) {
            sum += nums[i];
            queue.add(nums[i]);
            x++;
        }
        int j = 0;
        while (k-- > 0 && !queue.isEmpty()) {
            sum -= queue.poll();
            y++;
        }
        result = (double) sum / (x - y);
        return result;
    }
}
