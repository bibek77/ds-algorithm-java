package com.github.bibek77.dsa.dataStructures.recursion;

/**
 * @author bibek
 */
public class GCD {
    public static void main(String[] args) {
        GCD obj = new GCD();
        System.out.println(obj.gcd(48,18));
    }
    public int gcd(int a, int b) {
        if(b==0){
            return a;
        }
        if(a<=-1 || b<=-1) {
            return -1;
        }
        return gcd(b, a%b);
    }
}

