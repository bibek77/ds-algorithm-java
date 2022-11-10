package com.github.bibek77.dsa.dataStructures.trees.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bibek
 */
public class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfString;

    public TrieNode() {
        children = new HashMap<>();
        endOfString = false;
    }
}
