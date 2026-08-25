package com.github.bibek77.dsa.leetcode;

/**
 * @author bibek
 */
public class Lc130SurroundedRegions {

    static class Solution {
        public void solve(char[][] board) {
            if (board == null || board.length == 0) return;

            int rows = board.length;
            int cols = board[0].length;

            // Step 1: Run DFS from all border 'O's and mark them as safe ('#')
            for (int i = 0; i < rows; i++) {
                if (board[i][0] == 'O') dfs(board, i, 0);
                if (board[i][cols - 1] == 'O') dfs(board, i, cols - 1);
            }
            for (int j = 0; j < cols; j++) {
                if (board[0][j] == 'O') dfs(board, 0, j);
                if (board[rows - 1][j] == 'O') dfs(board, rows - 1, j);
            }

            // Step 2: Iterate through the board.
            // Convert surrounded 'O's to 'X', and restore safe '#'s back to 'O'
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    } else if (board[i][j] == '#') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        // Helper method to recursively mark connected 'O's
        private void dfs(char[][] board, int i, int j) {
            // Base case: Out of bounds or current cell is not 'O'
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
                return;
            }

            // Mark as safe
            board[i][j] = '#';

            // Explore all 4 directions
            dfs(board, i - 1, j); // Up
            dfs(board, i + 1, j); // Down
            dfs(board, i, j - 1); // Left
            dfs(board, i, j + 1); // Right
        }
    }
}