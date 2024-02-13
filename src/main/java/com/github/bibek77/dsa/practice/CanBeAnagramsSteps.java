package com.github.bibek77.dsa.practice;

/**
 * @author bibek
 */
public class CanBeAnagramsSteps {
    /**
     * Let's say there is a given string s
     * In how many steps string t can be converted to s
     * provide the minimum number of steps
     */
    public static void main(String[] args) {
        String s = "aba";
        String t = "bba";
        System.out.println("Steps required to convert : " + stepsToAnagram(s, t));
    }

    public static int stepsToAnagram(String s, String t) {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        char[] freqS = new char[26];
        char[] freqT = new char[26];
        int step = 0;

        for (int i = 0; i < s.length(); i++) {
            freqS[chs[i] - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            freqT[cht[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            step += Math.abs(freqS[i] - freqT[i]);
        }
        return step / 2;
    }
}
