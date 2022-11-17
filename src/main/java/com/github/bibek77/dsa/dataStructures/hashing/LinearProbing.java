package com.github.bibek77.dsa.dataStructures.hashing;

import java.util.ArrayList;

/**
 * @author bibek
 */
public class LinearProbing {
    String[] hashTable;
    int usedCellNumber;

    LinearProbing(int size) {
        hashTable = new String[size];
        usedCellNumber = 0;
    }

    //Hash Function to get the index of insertion
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

    public double getLoadFactor() {
        double loadFactor = usedCellNumber * 1.0 / hashTable.length;
        return loadFactor;
    }

    //Rehash
    public void rehashKeys(String word) {
        ArrayList<String> data = new ArrayList<>();
        for (String s : hashTable) {
            if (s != null)
                data.add(s);
        }
        data.add(word);
        hashTable = new String[hashTable.length * 2];
        for (String s : data) {
            insertHashTable(s);
        }
    }

    //Insertion Method
    public void insertHashTable(String word) {
        double loadFactor = getLoadFactor();
        if (loadFactor >= 0.75) {
            rehashKeys(word);
        } else {
            int index = modASCIIHashFunction(word, hashTable.length);
            for (int i = index; i < index + hashTable.length; i++) {
                int newIndex = i %  hashTable.length;
                if (hashTable[newIndex] == null) {
                    hashTable[newIndex] = word;
                    System.out.println("Word successfully inserted");
                    break;
                } else {
                    System.out.println("Index is already occupied.");
                }
            }
        }
        usedCellNumber += 1;
    }

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
