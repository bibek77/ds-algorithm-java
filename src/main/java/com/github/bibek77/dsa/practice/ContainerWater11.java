package com.github.bibek77.dsa.practice;

/**
 * @author bibek
 */
public class ContainerWater11 {

    public static void main(String[] args) {
        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int res = maxAreaBrute(height);
        int res2 = maxAreaOptimal(height);
        System.out.println(res);
        System.out.println(res2);
    }

    // Brute Force Solution
    public static int maxAreaBrute(int[] height) {

        int length = height.length;
        int volume = 0;
        for(int i=0;i<length-1;i++) {
            for(int j=i+1;j<length;j++) {
                int ht = Math.min(height[i], height[j]);
                int wd = j - i;
                volume = Math.max(volume, ht*wd);
            }
        }
        return volume;
    }

    // Optimal Solution
    public static int maxAreaOptimal(int[] height) {
        return 0;

    }
}
