package com.github.bibek77.dsa.dataStructures.recursion;

/**
 * @author bibek
 */
public class NumPower {
    public static void main(String[] args) {
        NumPower obj = new NumPower();
        System.out.println(obj.numpower(3, 2));
    }

    public int numpower(int base, int exp) {
        if (exp == 0) {
            return 1;
        }
        if (exp < 0) {
            return -1;
        }
        return base * numpower(base, exp - 1);
    }
}

