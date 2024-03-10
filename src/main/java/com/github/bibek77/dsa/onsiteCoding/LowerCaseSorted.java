package com.github.bibek77.dsa.onsiteCoding;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author bibek
 * Given an input string, return an output string such that all the lower case characters should be sorted. Indices of non-lower case characters should remain the same as in the original input string.
 * <p>
 * Eg. Input -> 'Test@123 Google'
 * Output -> 'Teeg@123 Gloost'
 */
public class LowerCaseSorted {
    public static void main(String[] args) {

        String word = "Test@123 Google";
        LowerCaseSorted lowerCaseSorted = new LowerCaseSorted();
        System.out.println(lowerCaseSorted.lowerCaseSorted(word));
        System.out.println(lowerCaseSorted.lowerCaseSortedSAlt(word));
    }

    public String lowerCaseSorted(String word) {
        char[] characters = word.toCharArray();
        int n = characters.length;
        ArrayList<Character> characterList = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isLowerCase(characters[i])) {
                characterList.add(characters[i]);
            }
        }
        Collections.sort(characterList);
        for (int i = 0; i < n; i++) {
            if (Character.isLowerCase(characters[i])) {
                characters[i] = characterList.get(j++);
            }
        }
        return new String(characters);
    }

    public String lowerCaseSortedSAlt(String word) {
        char[] characters = word.toCharArray();
        int n = characters.length;
        // Bubble sort
        for (int i = 0; i < n - 1; i++) {
            if (!Character.isLowerCase(characters[i])) continue;
            for (int j = i; j < n; j++) {
                if (!Character.isLowerCase(characters[j])) continue;
                if (characters[i] > characters[j]) {
                    char temp = characters[i];
                    characters[i] = characters[j];
                    characters[j] = temp;
                }
            }
        }
        return new String(characters);
    }
}
