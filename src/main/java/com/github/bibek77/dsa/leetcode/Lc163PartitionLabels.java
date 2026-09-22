package com.github.bibek77.dsa.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bibek
 */
public class Lc163PartitionLabels {
    static class Solution {
        public List<Integer> partitionLabels(String s) {

            int n = s.length();
            char[] ch = s.toCharArray();
            int r = 0;
            int l = 0;
            int[] lastIdx = new int[26];
            // Capture last index of each partition
            // this will help to know what index the partition will explad
            // for the current character
            for (int i = 0; i < n; i++) {
                lastIdx[ch[i] - 'a'] = i;
            }

            int partCurr = 0;
            List<Integer> result = new ArrayList<>();
            while (r < n) {
                // Any other character seen out side the partition will move the partition window.
                partCurr = Math.max(partCurr, lastIdx[ch[r] - 'a']);
                // when we traversed all chars in a current partition window
                // then we can get the length of the partition.
                // and start logic for new partition by moving l and r++
                if (r == partCurr) {
                    result.add(r - l + 1);
                    l = r + 1;
                }
                r++;
            }
            return result;
        }
    }
}
