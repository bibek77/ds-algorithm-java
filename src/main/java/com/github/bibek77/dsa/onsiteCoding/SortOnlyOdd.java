package com.github.bibek77.dsa.onsiteCoding;

/**
 * @author bibek
 * sort all odd elements and leave even elements as it is at their original position
 */
public class SortOnlyOdd {
    public static void main(String[] args) {
        int[] elements = {3, 20, 17, 9, 12, 15, 28, 99, 41, 40, 41, 60};
        // 3, 17, 9, 15, 99, 41, 41 - unsorted // odd
        // 3, 9, 15, 17, 41, 41, 99 - sorted // odd
        // 20, 12, 28, 40, 60 - unsorted // even
        // {3, 20, 9, 15, 12, 17, 28, 41, 41, 40, 99, 60} // unsorted - even // sorted - odd

        SortOnlyOdd sortOnlyOdd = new SortOnlyOdd();
        int[] result = sortOnlyOdd.sortOddElements(elements);
        for (int value : result) {
            System.out.print(value + ", ");
        }
    }

    public int[] sortOddElements(int[] elements) {
        sort(elements);
        return elements;
    }

    public void sort(int[] nums) {
        int n = nums.length;
        int temp = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] % 2 == 0) continue;
            for (int j = i + 1; j < n; j++) {
                if ((nums[j] % 2 == 0)) continue;
                if (nums[i] > nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
