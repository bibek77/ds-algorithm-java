package com.github.bibek77.dsa.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bibek
 */
public class LongestSubstring3 {

    public static void main(String[] args) {
        String word = "abcabcbb";
        System.out.println(longestSubstringBrute(word));
    }

    public static int longestSubstringBrute(String word) {
        char ch[] = word.toCharArray();
        int len = ch.length;
        int maxcount = 0, count=0;
        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.clear();
            count = 0;
            for (int j = i; j < len; j++) {
                if (!map.getOrDefault(ch[j], false)) {
                    map.put(ch[j], true);
                    count += 1;
                    maxcount = Math.max(maxcount, count);
                } else {
                    break;
                }
            }
        }
        return maxcount;

    }
}
