package com.github.bibek77.dsa.practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bibek
 */
public class ReplaceWords648 {
    TrieNodeMap root = new TrieNodeMap();
    public String replaceWords(List<String> dictionary, String sentence) {

        // Creation of TrieNode from dictionary.
        for(String word : dictionary) {
            TrieNodeMap currNode = root;
            for(char ch : word.toCharArray()) {
                if(currNode.child.get(ch)==null) {
                    currNode.child.put(ch, new TrieNodeMap());
                }
                currNode = currNode.child.get(ch);
            }
            currNode.endOfString = true;
        }

        String words[] = sentence.split(" ");
        StringBuilder sent = new StringBuilder();
        for(String word : words) {
            StringBuilder res = new StringBuilder();
            TrieNodeMap currNode = root;
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

class TrieNodeMap {
    Map<Character, TrieNodeMap> child = new HashMap<>();
    boolean endOfString = false;
}
