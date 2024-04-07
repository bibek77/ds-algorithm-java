package com.github.bibek77.dsa.onsiteCodingEasy;

/**
 * @author bibek
 * Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
 * <p>
 * Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
 */
public class Swap2EqualString {

    public static void main(String[] args) {
        String s1 = "aadbc";
        String s2 = "aacbd";
        Swap2EqualString swap2EqualString = new Swap2EqualString();
        System.out.println(swap2EqualString.buddyStrings(s1, s2));
    }

    public boolean buddyStrings(String s, String goal) {
        int l1 = s.length();
        int l2 = goal.length();
        boolean swap = false;
        if (l1 != l2)
            return false;

        int count = 0;
        int a = -1, b = -1;
        int[] freq = new int[26];
        for (int i = 0; i < l1; i++) {
            char c1 = s.charAt(i);
            char c2 = goal.charAt(i);
            // this ensures if there are min 2 dupl chars
            // that can be swapped to make string equal
            if (++freq[c1 - 'a'] >= 2)
                swap = true;
            if (c1 != c2) {
                count++;
                //first different index should be captured only for a
                // 2nd different index should be captured only for b
                // hence -1, will add value first time to a, and b is restricted
                // to update by having it in else block
                // next time a will already have value hence we store b as next different
                // chars index
                if (a == -1)
                    a = i;
                else if (b == -1)
                    b = i;
            }
        }
        // either there are some dupl chars and no mismatch chars
        // or there are exactly 1 mismatch chars at a and b index postion that are equal
        return (count == 0 && swap) || (count == 2 && s.charAt(a) == goal.charAt(b) && s.charAt(b) == goal.charAt(a));
    }
}
