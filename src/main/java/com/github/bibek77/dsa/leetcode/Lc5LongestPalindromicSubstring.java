package com.github.bibek77.dsa.leetcode;

/**
 * @author bibek
 */
public class Lc5LongestPalindromicSubstring {
    static class Solution {
        public String longestPalindrome(String s) {

            // from each point move both ways and keep the longest length
            // check for odd and even type.

            int n = s.length();
            char[] ch = s.toCharArray();
            int low = 0;
            int high = 0;
            int length = 0;
            String palindrome = "";

            for (int i = 0; i < n; i++) {
                // odd length like "dad"
                low = i;
                high = i;
                // expanding for odd length palindrome
                while (low >= 0 && high < n && ch[low] == ch[high]) {
                    if (length < high - low + 1) {
                        length = high - low + 1;
                        palindrome = s.substring(low, high + 1);
                    }
                    low--;
                    high++;
                }

                // even length like "maam"
                low = i - 1;
                high = i;
                // expanding for even length palindrome
                while (low >= 0 && high < n && ch[low] == ch[high]) {
                    if (length < high - low + 1) {
                        length = high - low + 1;
                        palindrome = s.substring(low, high + 1);
                    }
                    low--;
                    high++;
                }

            }
            return palindrome;
        }
    }
}
