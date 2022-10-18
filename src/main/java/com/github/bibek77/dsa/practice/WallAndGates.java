package com.github.bibek77.dsa.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bibek
 */
public class WallAndGates {
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int wall = -1;
    int gate = 0;
    int empty = Integer.MIN_VALUE;

    public WallAndGates(int[][] grid) {

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == gate) {
                    dfs(grid, row, col, 0);
                }
            }
        }

    }

    public void dfs(int[][] grid, int row, int col, int step) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || step > grid[row][col]) {
            return;
        }
        grid[row][col] = step;

        for (int[] currDir : dir) {
            dfs(grid, row + currDir[0], col + currDir[1], step + 1);
        }
    }

//    public void bfs(int[][] grid) {
//        int step = 0;
//        Queue<int[]> queue = new LinkedList<>();
//        for (int row = 0; row < grid.length; row++) {
//            for (int col = 0; col < grid[0].length; col++) {
//                if (grid[row][col] == gate) {
//                    queue.add(new int[]{row, col});
//                }
//            }
//        }
//
//        int len = queue.size();
//        while (!queue.isEmpty()) {
//
//            if (len == 0) {
//                len = queue.size();
//            }
//            len--;
//
//            int[] gateArr = queue.remove();
//            int x = gateArr[0];
//            int y = gateArr[1];
//
//            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || step > grid[x][y])
//                return;
//
//            grid[x][y] = step;
//
//            for (int[] currDir : dir) {
//                queue.add(new int[]{x + currDir[0], y + currDir[1]});
//            }
//        }


    }
}
