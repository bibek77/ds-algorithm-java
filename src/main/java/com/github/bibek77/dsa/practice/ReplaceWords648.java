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
        StringBuilder sent = new StringBuilder();
        for(String word : words) {
            StringBuilder res = new StringBuilder();
            TrieNode currNode = root;
            for(char ch : word.toCharArray()) {
                if(currNode.child.get(ch)!=null && !currNode.endOfString) {
                    res.append(ch);
                    currNode = currNode.child.get(ch);
                }else {
                    break;
                }
            }
            if(!currNode.endOfString)
                res = new StringBuilder();
            sent.append(res.toString().equalsIgnoreCase("") ? word : res);
            sent.append(" ");
        }
        return sent.toString().trim();
    }
}

class TrieNode {
    Map<Character, TrieNode> child = new HashMap<>();
    boolean endOfString = false;
}
