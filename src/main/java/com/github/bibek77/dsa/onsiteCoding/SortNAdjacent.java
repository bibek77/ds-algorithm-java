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
        int[] result = sortNAdjacent.sortNAdjacent(input);
        for (int val : input) {
            System.out.print(val + ", ");
        }
    }

    public int[] sortNAdjacent(int[] input) {


        return input;
    }
}
