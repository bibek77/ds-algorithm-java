package com.github.bibek77.dsa.dataStructures.array;

import java.util.Arrays;

/**
 * @author bibek
 */
public class TwoDArray {
    public static void main(String[] args) {
        int arr[][] = new int[3][3];
        int counter = 0;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                arr[i][j] = counter++;
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }
}
