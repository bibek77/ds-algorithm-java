package com.github.bibek77.dsa.onsiteCoding;

/**
 * @author bibek
 * Given an array nums with 'n' objects of 'r' types , sort them in-place so that objects of the same type are adjacent and are in the order provided. You must solve this problem without using the library's sort function.
 * <p>
 * 1<= n <= 1000
 * 1<= r <=50
 * <p>
 * Example 1:
 * Consider a shelf in walmart which has inventory of type bread, chocolate, or chips
 * r = 3
 * Rearrange the shelf in the order bread, chocolate, and chips.
 * We will use the integers 0, 1, and 2 to represent the color bread, chocolate, and chips, respectively.
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */
public class SortNAdjacent {

    public static void main(String[] args) {
        int[] input = {2, 0, 2, 1, 1, 0};

        SortNAdjacent sortNAdjacent = new SortNAdjacent();
        for (int val : input) {
            System.out.print(val + ", ");
        }

        int[] result = sortNAdjacent.sortNAdjacent(input);
        System.out.println();
        for (int val : result) {
            System.out.print(val + ", ");
        }
    }

    public int[] sortNAdjacent(int[] input) {
        // Using 3 pointers.
        // Goal is to compare and swap mid - pointer.
        // If mid - encounter 0 , swap with low.
        // If mid - encounters 1, swap with high.
        int n = input.length;
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (input[mid] == 1) {
                mid++;
            } else if (input[mid] == 0) {
                swap(input, low, mid);
                low++;
                mid++;
            } else { // input[mid] == 2
                swap(input, mid, high);
                high--;
            }
        }
        return input;
    }

    public void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
