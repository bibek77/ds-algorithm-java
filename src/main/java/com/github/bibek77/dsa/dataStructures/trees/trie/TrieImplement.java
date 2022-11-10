package com.github.bibek77.dsa.dataStructures.trees.trie;

import com.github.bibek77.dsa.dataStructures.trees.simpleTrees.TreeNode;

/**
 * @author bibek
 */
public class TrieImplement {
    private TrieNode root;

    public TrieImplement() {
        root = new TrieNode();
        System.out.println("Trie is now created");
    }

    public void insert(String word) {
        TrieNode currNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = currNode.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                currNode.children.put(ch, node);
            }
            currNode = node;
        }
        currNode.endOfString = true;
        System.out.println(word + " is successfully inserted in the Trie");
    }

    public boolean search(String word) {

        TrieNode currNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = currNode.children.get(ch);
            if (node == null) {
                System.out.println("Word does not exist in Trie.");
                return false;
            }
            currNode = node;
        }
        if (currNode.endOfString) {
            System.out.println("Word exists in trie");
            return true;
        } else {
            System.out.println("Word is not complete string in Trie, its a prefix.");
            return false;
        }
    }
}
