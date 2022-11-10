package com.github.bibek77.dsa.dataStructures.trees.trie;

/**
 * @author bibek
 */
public class MainClass {
    public static void main(String[] args) {
        TrieImplement trieImplement = new TrieImplement();
        trieImplement.insert("batman");
        trieImplement.insert("batboy");
        trieImplement.search("batman");
        trieImplement.search("bat");
        trieImplement.search("demon");
        trieImplement.search("batboy");

        trieImplement.deleteWord("batboy");
        trieImplement.search("batboy");
    }
}
