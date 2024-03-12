package com.github.bibek77.dsa.onsiteCoding;

import java.sql.Array;
import java.util.*;

/**
 * @author bibek
 * Give a list of string, where every string in the list is of size 5. Return the list of 5 string such that all the characters in each of the strings are unique
 * i.e. if we combine all the strings(not nnecessary) we will have 25 unique characters
 * e.g.
 * Input explanation
 * List of string with length of 5 each
 * input = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "zabcd", "apple", "zebra", "ocean", "quick", "world", "jumps", "foxes", "liver"]
 */
public class UniqueStrings {
    TrieNode root;

    public static void main(String[] args) {

        List<String> words = Arrays.asList("abcde", "fghij", "klmno", "pqrst", "uvwxy", "zabcd", "apple", "zebra", "ocean", "quick", "world", "jumps", "foxes", "liver");
        UniqueStrings uniqueStrings = new UniqueStrings();
        List<String> result = uniqueStrings.uniqueStrings(words);
        result.forEach(System.out::println);
    }

    public List<String> uniqueStrings(List<String> words) {
        return dfs(0, 0, words, new HashSet<>());
    }

    public List<String> dfs(int i, int currentWordCount, List<String> words, Set<Character> usedWords) {
        if (currentWordCount == 5) { // all required number achieved
            return new ArrayList<>();
        }
        // Base Case exhausted number of words
        if (i == words.size()) {
            return null;
        }
        // skip current word and try next words - A
        List<String> result = dfs(i + 1, currentWordCount, words, usedWords);

        if (result != null) {
            return result;
        }
        //proceed if the word has all unique chars and can be used
        if (canAdd(i, words, usedWords)) {
            for (char ch : words.get(i).toCharArray()) {
                usedWords.add(ch);
            }
            // use current word too - B
            result = dfs(i + 1, currentWordCount + 1, words, usedWords);

            if (result != null) {
                result.add(words.get(i));
                return result;
            }
            // backtrack to be able to add other words with same set of chars.
            for (char ch : words.get(i).toCharArray()) {
                usedWords.remove(ch);
            }
        }
        return null;
    }

    // if all 5 chars can be added for the word, then the word can be added returns true
    public boolean canAdd(int index, List<String> words, Set<Character> usedWords) {
        for (char c : words.get(index).toCharArray()) {
            if (usedWords.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public void insertToTrie(char[] word) {
        TrieNode currNode = root;
        for (char ch : word) {
            if (!currNode.child.containsKey(ch)) {
                currNode.child.put(ch, new TrieNode());
            }
            currNode = currNode.child.get(ch);
        }
        currNode.endOfString = true;
    }

    static class TrieNode {
        Map<Character, TrieNode> child;
        boolean endOfString;

        TrieNode() {
            child = new HashMap<>();
            endOfString = false;
        }
    }
}
