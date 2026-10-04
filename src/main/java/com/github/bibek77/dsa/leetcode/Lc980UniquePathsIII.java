package com.github.bibek77.dsa.leetcode;

/**
 * @author bibek
 */
public class Lc980UniquePathsIII {
    static class Solution {
        public int uniquePathsIII(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int emptySquares = 1; // Start at 1 to account for the starting square itself
            int startX = 0, startY = 0;

            // 1. Find the start and count total valid steps needed
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        emptySquares++;
                    } else if (grid[i][j] == 1) {
                        startX = i;
                        startY = j;
                    }
                }
            }

            return dfs(grid, startX, startY, emptySquares);
        }

        private int dfs(int[][] grid, int r, int c, int remainingEmpty) {
            // 2. Base Cases (Out of bounds or hitting a wall/visited node)
            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == -1) {
                return 0;
            }

            // 3. Success Case (Reached destination)
            if (grid[r][c] == 2) {
                return remainingEmpty == 0 ? 1 : 0;
            }

            // 4. Mark as visited
            grid[r][c] = -1;
            remainingEmpty--;

            // 5. Explore all 4 directions
            int totalPaths = dfs(grid, r + 1, c, remainingEmpty) +
                    dfs(grid, r - 1, c, remainingEmpty) +
                    dfs(grid, r, c + 1, remainingEmpty) +
                    dfs(grid, r, c - 1, remainingEmpty);

            // 6. Backtrack (Unmark as visited)
            grid[r][c] = 0;

            return totalPaths;
        }
    }
}
