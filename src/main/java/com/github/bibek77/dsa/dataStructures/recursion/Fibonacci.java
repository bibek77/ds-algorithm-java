package com.github.bibek77.dsa.dataStructures.recursion;

/**
 * @author bibek
 */
public class Fibonacci {

    public static void main(String[] args) {

        Fibonacci obj = new Fibonacci();
        System.out.println(obj.fibonacci(4));
    }
    public int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else if (n < 0) {
            return -1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
