package com.github.bibek77.dsa.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bibek
 */
public class LongestSubstring3 {

    public static void main(String[] args) {
        String word = "dvdfei";
        System.out.println(longestSubstringBrute(word));
        System.out.println(longestSubstringOptimal(word));
    }

    public static int longestSubstringOptimal(String word) {
        char ch[] = word.toCharArray();
        int len = ch.length;
        int pointer1 = 0, pointer2 = 0;
        int maxcount = 0, count = 0;
        Map<Character, Integer> map = new HashMap<>();
        if (len <= 1)
            return len;
        while (pointer2 < len) {
            if (map.getOrDefault(ch[pointer2], -1) >= pointer1) {
                pointer1 = map.get(ch[pointer2]) + 1;
            }
            map.put(ch[pointer2], pointer2);
            maxcount = Math.max(maxcount, pointer2 - pointer1 + 1);
            pointer2++;

        }
        return maxcount;
    }

    public static int longestSubstringBrute(String word) {
        char ch[] = word.toCharArray();
        int len = ch.length;
        int maxcount = 0, count = 0;
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
