package com.github.bibek77.dsa.practice;

/**
 * @author bibek
 */
public class ValidPalindromeII680 {
    // remove one character to make palindrome , almost palindrome
    public static void main(String[] args) {
        String word = "madasm";
        System.out.println(palindromeOptimal(word));
    }

    public static boolean palindromeOptimal(String word) {
        char chr[] = word.toCharArray();
        int left = 0, right = chr.length - 1;
        while (left < right) {
            if (chr[left] != chr[right]) {
                return (makeValidPalindrome(chr, left + 1, right) || makeValidPalindrome(chr, left, right - 1));
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean makeValidPalindrome(char[] word, int left, int right) {
        while (left < right) {
            if (word[left] != word[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
}
