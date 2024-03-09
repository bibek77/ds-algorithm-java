package com.github.bibek77.dsa.onsiteCoding;

/**
 * @author bibek
 * A number of students are taking exams in a room.
 * Students sitting adjacent to each other and taking the same exam can cheat.
 * Arrange the students so that cheating opportunities are minimised.
 * free to choose input format.
 * Input to be a list of length n, denoting n students.
 * The element at index i would indicate the exam ith student is taking.
 * For example, [1,2,3,1,2,2]
 * Student 0 is taking exam 1
 * Student 1 is taking exam 2
 * Student 2 is taking exam 3
 * Student 3 is taking exam 1
 * Student 4 is taking exam 2
 * Student 5 is taking exam 2
 */
public class AdjacentCheating {

    public static void main(String[] args) {

        int[] exams = {1, 2, 3, 1, 2, 2};
        for (int value : exams) {
            System.out.print(value + ", ");
        }
        System.out.println();

        AdjacentCheating adjacentCheating = new AdjacentCheating();
        int[] result = adjacentCheating.arrangeExam(exams);

        for (int value : result) {
            System.out.print(value + ", ");
        }
    }

    public int[] arrangeExam(int[] exam) {
        int n = exam.length;
        int[] result = new int[n];
        int[] frequency = new int[101];
        // Expecting max there can be 100 different exams.

        int maxFrequency = -1;
        int maxExam = -1;

        for (int i = 0; i < n; i++) {
            frequency[exam[i]]++;
            if (maxFrequency < frequency[exam[i]]) {
                maxFrequency = frequency[exam[i]];
                maxExam = exam[i];
            }
        }

        // checking if max examination's count is greater than half
        // then arrangement is not possible return empty array
        if (maxFrequency > (n + 1) / 2)
            return result;

        // placing the max examination evenly in alternate places.
        int index = 0;
        for (int i = 0; i < maxFrequency; i++) {
            result[index] = maxExam;
            frequency[maxExam]--;
            index += 2;
        }

        // placing rest of the exam, in alternating index
        // once reaches the size, we will start alternating from 1 index,
        for (int i = 0; i < 101; i++) {
            while (frequency[i] > 0) {
                if (index >= n) {
                    index = 1;
                }
                result[index] = i;
                index += 2;
                frequency[i]--;
            }
        }
        return result;
    }


}
