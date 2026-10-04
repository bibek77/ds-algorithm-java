package com.github.bibek77.dsa.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bibek
 */
public class Lc1520MaxNumOfNonOverlapSubstring {
    static class Solution {
        public List<String> maxNumOfSubstrings(String s) {
            char[] ch = s.toCharArray();
            int n = s.length();

            // 1. Find first and last occurrences of each character
            int[][] pos = new int[26][2];
            for (int i = 0; i < 26; i++) {
                pos[i] = new int[]{-1, -1};
            }
            for (int i = 0; i < n; i++) {
                if (pos[ch[i] - 'a'][0] == -1) {
                    pos[ch[i] - 'a'][0] = i;
                }
                // Always update the last seen position
                pos[ch[i] - 'a'][1] = i;
            }

            List<String> result = new ArrayList<>();
            int lastRight = -1;

            // 2. Greedily find valid substrings
            for (int i = 0; i < n; i++) {
                // Only process if it's the first time we see this character
                if (i == pos[ch[i] - 'a'][0]) {
                    int right = getExpandedRightBound(ch, i, pos);

                    if (right != -1) {
                        // If this valid interval starts strictly after the last one we added,
                        // we can safely add it as a new non-overlapping interval.
                        if (i > lastRight) {
                            result.add(s.substring(i, right + 1));
                        } else {
                            // Otherwise, it's a valid interval completely nested INSIDE the last one.
                            // We replace the last one with this smaller interval to minimize length.
                            result.set(result.size() - 1, s.substring(i, right + 1));
                        }
                        lastRight = right;
                    }
                }
            }
            return result;
        }

        // Helper method to expand the interval and check for validity
        private int getExpandedRightBound(char[] ch, int start, int[][] pos) {
            int right = pos[ch[start] - 'a'][1];

            for (int j = start; j <= right; j++) {
                // If any character inside our current window starts BEFORE our window,
                // this substring is invalid.
                if (pos[ch[j] - 'a'][0] < start) {
                    return -1;
                }
                // Expand the right boundary if a character requires it
                right = Math.max(right, pos[ch[j] - 'a'][1]);
            }
            return right;
        }
    }
}
