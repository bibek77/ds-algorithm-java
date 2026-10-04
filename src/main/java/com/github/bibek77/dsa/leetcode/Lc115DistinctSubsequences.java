package com.github.bibek77.dsa.leetcode;

import java.util.Arrays;

/**
 * @author bibek
 */
public class Lc115DistinctSubsequences {
    static class Solution {
        public int numDistinct(String s, String t) {
            int m = s.length();
            int n = t.length();
            int[][] dp = new int[m][n];
            for (int[] rows : dp) {
                Arrays.fill(rows, -1);
            }

            return dfs(0, 0, s, t, dp);
        }

        public int dfs(int i, int j, String s, String t, int[][] dp) {
            if (j == t.length())
                return 1;

            if (i == s.length()) // target string traversal is not complete but we exhausted s string , so string did not match;
                return 0;

            if (dp[i][j] != -1)
                return dp[i][j];

            // logic
            int ways = 0;
            if (s.charAt(i) == t.charAt(j)) {
                ways = dfs(i + 1, j + 1, s, t, dp) + dfs(i + 1, j, s, t, dp);
            } else {
                ways = dfs(i + 1, j, s, t, dp);
            }

            dp[i][j] = ways;
            return dp[i][j];
        }
    }
}


