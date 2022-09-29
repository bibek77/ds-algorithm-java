package com.github.bibek77.dsa.dataStructures.recursion;

/**
 * @author bibek
 */
public class Factorial {
    public static void main(String[] args) {
        Factorial obj = new Factorial();
        System.out.println(obj.factorial(5));
        System.out.println(obj.factorial(5, 1));
    }

    public int factorial(int n) {

        if (n > 1) return n * factorial(n - 1);
        if (n < 0) return -1;
        else return 1;
    }

    public int factorial(int n, int totalSoFar) {
        if (n == 0) return totalSoFar;
        else return factorial(n-1, totalSoFar*n);
    }
}
