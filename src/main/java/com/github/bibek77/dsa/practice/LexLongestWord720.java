package com.github.bibek77.dsa.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bibek
 */
public class LexLongestWord720 {

    TrieNodeArr root = new TrieNodeArr();

    public String longestWord(String[] words) {
        for(String word : words){
            insertTrie(word);
        }

        return findLongest();

    }

    public void insertTrie(String word){
        TrieNodeArr currNode = root;
        for(char ch : word.toCharArray()) {
            if(currNode.child[ch-'a']==null)
                currNode.child[ch-'a'] = new TrieNodeArr();
            currNode = currNode.child[ch-'a'];
        }
        currNode.endOfString = true;
        currNode.nodeWord = word;
    }

    // For finding longest word lexicographically from first is by going from z to a
    // using as queue to do a bfs search also word is stored at every end nodes
    // so can be retrieved everytime we reach a end of node.
    public String findLongest() {
        TrieNodeArr currNode = root;
        String result = "";
        Queue<TrieNodeArr> queue = new LinkedList<>();
        queue.add(currNode);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TrieNodeArr node = queue.poll();
                for(int j=25;j>=0;j--) {
                    if(node.child[j]!=null && node.child[j].endOfString) {
                        result = node.child[j].nodeWord;
                        queue.add(node.child[j]);
                    }
                }
            }
        }
        return result;
    }
}

class TrieNodeArr {
    TrieNodeArr[] child = new TrieNodeArr[26];
    boolean endOfString = false;
    String nodeWord = "";

}