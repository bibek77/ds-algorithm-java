package com.github.bibek77.dsa.practice;

/**
 * @author bibek
 */
public class ValidPalindrome125 {
    public static void main(String[] args) {
        String word = ".,";
        System.out.println(palindromeBrute(word));
        System.out.println(palindromeOptimal(word));
    }

    public static boolean palindromeBrute(String word) {

        word = word.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        ;

        int len = word.length();
        int left = 0, right = len - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean palindromeOptimal(String word) {
        char chr[] = word.toLowerCase().toCharArray();
        int left = 0, right = chr.length - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(chr[left])) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(chr[right])) {
                right--;
            }

            if (chr[left] != chr[right])
                return false;
            left++;
            right--;

        }
        return true;
    }
}
