package com.github.bibek77.dsa.miscellaneous;

import java.util.*;

/**
 * @author bibek
 */
public class MatrixDFS {
    int[][] directions;

    public MatrixDFS() {
        this.directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] matrix = {{2, 4, 6}, {7, 1, 0}, {9, 8, 5}};
        boolean[][] seenDfs = new boolean[matrix.length][matrix[0].length];
        boolean[][] seenBfs = new boolean[matrix.length][matrix[0].length];
        Arrays.stream(seenDfs).forEach(row-> Arrays.fill(row, false));
        Arrays.stream(seenBfs).forEach(row-> Arrays.fill(row, false));
//        for(boolean[] row: seenDfs) {
//            Arrays.fill(row, false);
//        }
//        for(boolean[] row: seenBfs) {
//            Arrays.fill(row, false);
//        }
        ArrayList<Integer> valuesDfs = new ArrayList<>();
        ArrayList<Integer> valuesBfs = new ArrayList<>();
        dfs(matrix, 0, 0, seenDfs, valuesDfs);
        bfs(matrix, seenBfs, valuesBfs);
        valuesDfs.forEach(System.out::print);
        System.out.println();
        valuesBfs.forEach(System.out::print);

    }

    public void dfs(int[][] matrix, int m, int n, boolean[][] seen, ArrayList<Integer> values) {
        if (m < 0 || n < 0 || m >= matrix.length || n >= matrix[0].length || seen[m][n])
            return;
        values.add(matrix[m][n]);
        seen[m][n] = true;

        for (int[] currDir : directions) {
            dfs(matrix, m + currDir[0], n + currDir[1], seen, values);
        }
    }

    public void bfs(int[][] matrix, boolean[][] seen, ArrayList<Integer> values) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (queue.size() > 0) {
            int[] position = queue.remove();
            int row = position[0];
            int col = position[1];
            if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || seen[row][col]) {
                continue;
            }
            seen[row][col] = true;
            values.add(matrix[row][col]);
            for (int[] currDir : directions) {
                queue.add(new int[]{row + currDir[0], col + currDir[1]});
            }
        }
    }

}
