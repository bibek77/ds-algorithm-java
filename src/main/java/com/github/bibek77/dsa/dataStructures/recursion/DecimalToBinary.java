package com.github.bibek77.dsa.dataStructures.recursion;

/**
 * @author bibek
 */
public class DecimalToBinary {
    public static void main(String[] args) {
        DecimalToBinary obj = new DecimalToBinary();
        System.out.println(obj.decimalToBinary(10));
    }

    public int decimalToBinary(int num) {
        if (num == 0) {
            return 0;
        }
        return (num % 2) + 10 * decimalToBinary(num / 2);
    }
}
