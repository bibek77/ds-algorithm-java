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

    public boolean delete(TrieNode parentNode, String word, int index) {
        char ch = word.charAt(index);
        TrieNode currNode = parentNode.children.get(ch);
        boolean canDeleteTheNode;
        // 1st case - Some other words prefix is same as this words prefix
        // We can only move through the prefix part , cannot remove
        // If children size is more than one then can have more path or words
        if (currNode.children.size() > 1) {
            delete(currNode, word, index + 1);
            return false;
        }
        // 2nd case - Last character of the tb deleted word is a prefix of some other word.
        // Can be proved if the very last character children has one or more node.
        if (index == word.length() - 1) {
            // if cond proves that its currently at the last character
            // If it's a prefix we cannot remove.
            if (currNode.children.size() >= 1) {
                currNode.endOfString = false;
                return false;
            } else {
                // If it does not have any prefix we can remove the last character
                parentNode.children.remove(ch);
                return true;
            }
        }
        //3rd case - Some other word is a prefix of tb deleted word that is
        // tb deleted - abcd, prefix word - ab, so cannot delete unto ab
        // We set end of string after each word inserted to let know there is a word ended
        if (currNode.endOfString) {
            delete(currNode, word, index + 1);
            return false;
        }
        //4th case - No other word is dependent, so we can successfully delete the word.
        // checking the return value by recursion.
        canDeleteTheNode = delete(currNode, word, index + 1);
        if (canDeleteTheNode) {
            parentNode.children.remove(ch);
            return true;
        } else {
            return false;
        }
    }

    public void deleteWord(String word) {
        if (search(word)) {
            delete(root, word, 0);
        }
    }
}
