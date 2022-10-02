package com.github.bibek77.dsa.practice;

/**
 * @author bibek
 */
public class Hourglass1629 {

    public static void main(String[] args) {
        int arr[][] = {{0,5,7},{4,8,2},{20,98,23}};
        System.out.println(maxSum(arr));
    }
        public static int maxSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int sum=0, maxSum=0;
            for(int i=0;i<=m-3;i++) {

                for(int j=0;j<=n-3;j++) {
                    sum = sum + grid[i][j] + grid[i][j+1] + grid[i][j+2];
                    sum = sum + grid[i+1][j+1];
                    sum = sum + grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];
                }
                maxSum = Math.max(maxSum, sum);
                sum =0;
            }
            return maxSum;
    }
}
