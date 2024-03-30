package com.github.bibek77.dsa.onsiteCoding;

/**
 * @author bibek
 * Given an m X n grid, you have to start from bottom left and end at bottom right. You can make three moves
 * <p>
 * one step to right - (i, j+1)
 * diagonal - (i+1, j+1) (i-1, j+1)
 * Find how many unique paths are present.
 */
public class BottomLeftRight {
    public static void main(String[] args) {
        int[][] grid = new int[4][5];
        int uniquePaths = findUniquePaths(grid);
        System.out.println(uniquePaths);
    }

    public static int findUniquePaths(int[][] grid) {
        // Implementation Logic
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n + 1][m + 1];
        dp[n][1] = 1;

        // 3 directions are visited
        // we capture all paths from previous paths as memoized
        // for right from previous , dp[i-1][j-1]
        // for /^ diagonal , dp[i+1][j-1]
        // for \, diagonal, dp[i-1][j-1]
        for (int j = 1; j <= m; j++) {
            for (int i = n; i >= 1; i--) {
                dp[i][j] += dp[i][j - 1];
                dp[i][j] += dp[i - 1][j - 1];
                if (i + 1 <= n)
                    dp[i][j] += dp[i + 1][j - 1];
            }
        }
        return dp[n][m];
    }
}
