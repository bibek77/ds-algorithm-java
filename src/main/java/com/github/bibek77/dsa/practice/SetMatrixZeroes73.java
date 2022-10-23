package com.github.bibek77.dsa.practice;

/**
 * @author bibek
 */
public class SetMatrixZeroes73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] seen = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 0 && seen[i][j] == 0) {
                    seen[i][j] = -1;
                    int row = 0, col = 0;
                    while (row < m) {
                        if (matrix[row][j] != 0) {
                            matrix[row][j] = 0;
                            seen[row][j] = 1;
                        }
                        row++;
                    }
                    while (col < n) {
                        if (matrix[i][col] != 0) {
                            matrix[i][col] = 0;
                            seen[i][col] = 1;
                        }
                        col++;
                    }

                }

            }
        }
    }
}
