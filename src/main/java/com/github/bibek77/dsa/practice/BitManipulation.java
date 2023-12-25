package com.github.bibek77.dsa.practice;

/**
 * @author bibek
 */
public class BitManipulation {
    public static void main(String[] args) {

        int num = 64;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            System.out.println("bit : " + bit + " num >> i " + (num >> i));
        }
    }
}
