package com.github.bibek77.dsa.practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bibek
 */
public class ReplaceWords648 {
    TrieNode root = new TrieNode();
    public String replaceWords(List<String> dictionary, String sentence) {

        // Creation of TrieNode from dictionary.
        for(String word : dictionary) {
            TrieNode currNode = root;
            for(char ch : word.toCharArray()) {
                if(currNode.child.get(ch)==null) {
                    currNode.child.put(ch, new TrieNode());
                }
                currNode = currNode.child.get(ch);
            }
            currNode.endOfString = true;
        }

        String words[] = sentence.split(" ");
        String sent = "";
        for(String word : words) {
            String res = "";
            TrieNode currNode = root;
            for(char ch : word.toCharArray()) {
                if(currNode.child.get(ch)!=null && !currNode.endOfString) {
                    res = res + ch;
                    currNode = currNode.child.get(ch);
                }else {
                    // res = "";
                    break;
                }
            }
            if(!currNode.endOfString)
                res = "";
            sent = sent + (res.equalsIgnoreCase("") ? word : res) + " ";
        }
        return sent.trim();
    }
}

class TrieNode {
    Map<Character, TrieNode> child = new HashMap<>();
    boolean endOfString = false;
}
