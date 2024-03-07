package com.github.bibek77.dsa.onsiteCoding;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bibek
 * Given a matrix where land is marked as "X", water is marked as ".".
 * A "." is considered an ocean if it's unbounded on atleast one side.
 * A coast is any land directly connected to the ocean.
 * Water grid bounded on all sides by land is considerd a lake.
 * Find if a given grid (co-ordinate) is a coast.
 * <p>
 * Eg:
 * x x x x x x x x
 * . . . x . x . .
 * . . . x x . x .
 * <p>
 * isCoast(1, 3) returns True
 * <p>
 * . . . . . .
 * x x x . x .
 * x . x x . x
 * x x x . x x
 * x x x x x x
 * <p>
 * isCoast(3, 2) returns False
 */
public class CoastLandBfs {

    public static void main(String[] args) {

        char[][] grid = {
                {'.', '.', '.', '.', '.', '.'},
                {'x', 'x', 'x', '.', 'x', '.'},
                {'x', '.', 'x', 'x', '.', 'x'},
                {'x', 'x', 'x', '.', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x'}
        };

        boolean result1 = isCoastLand(grid, new int[]{3, 2});
        boolean result2 = isCoastLand(grid, new int[]{1, 4});
        System.out.println("Is Coast : " + result1);
        System.out.println("Is Coast : " + result2);

    }

    public static boolean isCoastLand(char[][] grid, int[] land) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // check if land coordinates is ".", then return false as not land
        // so definitely not a coast
        if (land[0] < 0 || land[0] >= n || land[1] < 0 || land[1] >= m) return false;
        if (grid[land[0]][land[1]] == '.') return false;

        Queue<int[]> queue = new LinkedList<>();

        for (int[] dir : dirs) {
            int nextx = dir[0] + land[0], nexty = dir[1] + land[1];
            if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= m || grid[nextx][nexty] == 'x')
                continue;
            else queue.add(new int[]{nextx, nexty});
        }

        // If all surrounding are land then not a coast.
        if (queue.isEmpty()) return false;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];
            if (visited[x][y]) continue;

            visited[x][y] = true;
            for (int[] dir : dirs) {
                int nextx = dir[0] + x, nexty = dir[1] + y;
                if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= m)
                    return true;
                else if (grid[nextx][nexty] == 'x')
                    continue;
                else queue.add(new int[]{nextx, nexty});
            }
        }

        return false;
    }
}
