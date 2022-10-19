package com.github.bibek77.dsa.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bibek
 */
public class MaxIslandArea695 {
    public int maxAreaOfIsland(int[][] grid) {

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int row = grid.length;
        int col = grid[0].length;

        if (row == 0)
            return 0;

        Queue<int[]> queue = new LinkedList<>();

        int area = 0;
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    grid[i][j] = 0;
                    area += 1;
                    while (!queue.isEmpty()) {
                        int[] curr = queue.remove();
                        for (int currDir[] : dir) {
                            int x = curr[0] + currDir[0];
                            int y = curr[1] + currDir[1];

                            if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0)
                                continue;
                            queue.add(new int[]{x, y});
                            grid[x][y] = 0;
                            area++;
                        }
                    }
                    maxArea = Math.max(area, maxArea);
                    area = 0;
                } else {
                    area = 0;
                }
            }
        }
        return Math.max(maxArea, area);
    }
}
