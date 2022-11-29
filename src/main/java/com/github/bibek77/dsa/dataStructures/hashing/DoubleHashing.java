package com.github.bibek77.dsa.dataStructures.hashing;

import java.util.ArrayList;

/**
 * @author bibek
 */
public class DoubleHashing {
    String[] hashTable;
    int noOfCellInHashTable;

    DoubleHashing(int size) {
        hashTable = new String[size];
        noOfCellInHashTable = 0;
    }

    // Hash Function to use for the keys
    public int simpleASCIIHashFunction(String word, int m) {
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

    public int addAllDigitsTogether(int sum) {
        int value = 0;
        while (sum > 0) {
            value += sum % 10;
            sum = sum / 10;
        }
        return value;
    }

    public int secondHashFunction(String s, int M) {
        char ch[];
        ch = s.toCharArray();
        int i, sum;
        for (sum = 0, i = 0; i < s.length(); i++) {
            sum += ch[i];
        }
        while (sum > hashTable.length) {
            sum = addAllDigitsTogether(sum);
        }
        return sum % M;
    }

    public double getLoadFactor() {
        return noOfCellInHashTable * 1.0 / hashTable.length;
    }

    public void insertHashTable(String value) {
        double loadFactor = getLoadFactor();
        if (loadFactor >= 0.75) {
            rehashKeys(value);
        } else {
            int x = simpleASCIIHashFunction(value, hashTable.length);
            int y = secondHashFunction(value, hashTable.length);
            for (int i = 0; i < hashTable.length; i++) {
                int newIndex = (x + i * y) % hashTable.length;
                if (hashTable[newIndex] == null) {
                    hashTable[newIndex] = value;
                    System.out.println("Value is inserted at location : " + newIndex);
                    break;
                } else {
                    System.out.println("New index is occupied , try other index :" + newIndex);
                }
            }
        }
        noOfCellInHashTable += 1;
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
