package com.github.bibek77.dsa.practice;

/**
 * @author bibek
 */
public class RemoveIslands {
    public static void main(String[] args) {
        RemoveIslands removeIslands = new RemoveIslands();
        int[][] inputGrid = {{1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}};
        System.out.println("Input Grid : ");
        for (int[] row : inputGrid) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();

        int[][] resultGrid = removeIslands.removeIslands(inputGrid);
        System.out.println("Result Grid : ");
        for (int[] row : resultGrid) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

    }

    public int[][] removeIslands(int[][] grid) {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = grid[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    for (int[] dir : dirs) {
                        int nextx = dir[0] + i;
                        int nexty = dir[1] + j;
                        if (nextx < 0 || nexty < 0 || nextx >= n || nexty >= m || grid[nextx][nexty] == 0) continue;
                        if (grid[nextx][nexty] == 1) count++;
                    }
                    if (count == 4) {
                        result[i][j] = 0;
                    }
                }
            }
        }
        return result;
    }
}
