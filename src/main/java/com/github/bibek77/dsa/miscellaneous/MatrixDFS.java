package com.github.bibek77.dsa.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bibek
 */
public class MatrixDFS {
    int[][] directions;

    public MatrixDFS() {
        this.directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] matrix = {{2, 4, 6}, {7, 1, 0}, {9, 8, 5}};
        boolean[][] seen = {{false, false, false}, {false, false, false}, {false, false, false}};
        ArrayList<Integer> values = new ArrayList<>();
        dfs(matrix, 0, 0, seen, values);
        values.forEach(System.out::println);

    }

    public void dfs(int[][] matrix, int m, int n, boolean[][] seen, ArrayList<Integer> values) {
        if (m < 0 || n < 0 || m >= matrix.length || n >= matrix[0].length || seen[m][n])
            return;
        values.add(matrix[m][n]);
        seen[m][n] = true;

        for (int i = 0; i < directions.length; i++) {
            int[] currDir = directions[i];
            dfs(matrix, m + currDir[0], n + currDir[1], seen, values);
        }
    }
}
