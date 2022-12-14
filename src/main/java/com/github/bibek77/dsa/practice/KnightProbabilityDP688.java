package com.github.bibek77.dsa.practice;

/**
 * @author bibek
 */
public class KnightProbabilityDP688 {
    int[][] dir = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    double[][][] dp;

    public double knightProbability(int n, int k, int row, int column) {
        dp = new double[k + 1][n][n];
        // return helper(n,k,row,column);

        // Tabulation or Iterative or Bottom-Up
        dp[0][row][column] = 1;
        for (int i = 1; i <= k; i++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    for (int d = 0; d < dir.length; d++) {
                        int[] currDir = dir[d];
                        int prevr = r + currDir[0];
                        int prevc = c + currDir[1];
                        if (prevr >= 0 && prevr < n && prevc >= 0 && prevc < n) {
                            dp[i][r][c] += dp[i - 1][prevr][prevc] / 8.0;
                        }
                    }
                }
            }
        }

        double res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += dp[k][i][j];
            }
        }
        return res;
    }

    public double helper(int n, int k, int row, int column) {
        if (row < 0 || column < 0 || row >= n || column >= n)
            return 0;
        if (k == 0)
            return 1;

        if (dp[k][row][column] != 0)
            return dp[k][row][column];

        double response = 0.0;
        for (int i = 0; i < dir.length; i++) {
            int cdir[] = dir[i];
            response += helper(n, k - 1, row + cdir[0], column + cdir[1]) / 8.0;
        }
        dp[k][row][column] = response;
        return response;
    }
}
