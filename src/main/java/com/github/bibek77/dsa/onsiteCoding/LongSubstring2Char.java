package com.github.bibek77.dsa.onsiteCoding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bibek
 * For a given string find the longest substring with atmost 2 unique characters in it.
 */
public class LongSubstring2Char {
    public static void main(String[] args) {
        List<String> test = Arrays.asList("aabcccddddddckffgggggggggg", "a", "ab", "", "aaakkk", "ttttt", "abababab");
        LongSubstring2Char longSubstring2Char = new LongSubstring2Char();
        for (String word : test) {
            System.out.println("word : " + word + ", longest sub : " + longSubstring2Char.longestString(word));
        }
    }

    public String longestString(String word) {
        int n = word.length();
        int i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] wordChar = word.toCharArray();
        int maxLen = 0;
        String maxWord = "";
        // We will keep i at beginning of longest word & j at end of longest word
        while (j < n) {
            map.put(wordChar[j], map.getOrDefault(wordChar[j], 0) + 1);

            // We repeatedly remove characters from the start until we have only 2 unique chars in map.
            while (map.size() > 2 && i <= j) {
                map.put(wordChar[i], map.get(wordChar[i]) - 1);
                // if all frequency of unique chars is removed then remove the char from map
                if (map.get(wordChar[i]) == 0) {
                    map.remove(wordChar[i]);
                }
                // increment start pointer
                i++;
            }
            // If we see a max Length substring, capture it
            if (maxLen < j - i + 1) {
                maxLen = j - i + 1;
                maxWord = word.substring(i, j + 1);
            }
            j++;
        }
        return maxWord;
    }
}
