package com.github.bibek77.dsa.dataStructures.hashing;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author bibek
 */
public class DirectChaining {
    LinkedList<String>[] hashTable;
    int maxChainSize = 5;

    public DirectChaining(int size) {
        hashTable = new LinkedList[size];
    }

    public int modASCIIHashFunction(String word, int m) {
        char ch[];
        ch = word.toCharArray();
        int i, sum;
        // sum of all the ascii value of characters in the word
        for (sum = 0, i = 0; i < word.length(); i++) {
            sum = sum + ch[i];
        }
        // modulo of sum is returned which gives the index to be stored at;
        return sum % m;
    }

    public void insertHashTable(String word) {
        int index = modASCIIHashFunction(word, hashTable.length);
        // if hashTable is null then we create instance.
        if (hashTable[index] == null) {
            hashTable[index] = new LinkedList<>();
        }
        // insert to the hashtable linkedList.
        hashTable[index].add(word);
    }

    // Displaying the HashTable
    public void displayHashTable() {
        if (hashTable == null) {
            System.out.println("HashTable does not exists");
        } else {
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println(hashTable[i]);
            }
        }
    }
}
