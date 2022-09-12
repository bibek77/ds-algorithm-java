package com.github.bibek77.dsa.practice;

/**
 * @author bibek
 */
public class TrappingRainWater42 {

    public static void main(String[] args) {
        int height[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int res = maxAreaBrute(height);
        int res2 = maxAreaOptimal(height);
        System.out.println(res);
        System.out.println(res2);
    }

    // Brute Force Solution
    public static int maxAreaBrute(int[] height) {
        int totalWater = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int len = height.length;
        for (int i = 0; i < len - 1; i++) {
            maxLeft = i!=0 ? Math.max(maxLeft, height[i-1]) : 0;
            for (int j = i+1; j < len; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            totalWater = totalWater + (Math.max(Math.min(maxLeft, maxRight) - height[i], 0));
            maxRight = 0;
        }
        return totalWater;
    }

    // Optimal Solution
    public static int maxAreaOptimal(int[] height) {

        return 0;

    }
}
