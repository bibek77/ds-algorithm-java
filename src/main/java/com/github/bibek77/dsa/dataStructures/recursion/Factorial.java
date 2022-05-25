package com.github.bibek77.dsa.dataStructures.recursion;

/**
 * @author bibek
 */
public class Factorial {
    public static void main(String[] args) {
        Factorial obj = new Factorial();
        System.out.println(obj.factorial(5));
    }

    public int factorial(int n) {

        if (n > 1) return n * factorial(n - 1);
        if (n < 0) return -1;
        else return 1;
    }
}
