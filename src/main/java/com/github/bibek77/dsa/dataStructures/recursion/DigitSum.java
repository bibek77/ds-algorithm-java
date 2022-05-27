package com.github.bibek77.dsa.dataStructures.recursion;

/**
 * @author bibek
 */
public class DigitSum {
    public static void main(String[] args) {
        DigitSum obj = new DigitSum();
        System.out.println(obj.getDigitSum(11789));
    }
    public int getDigitSum(int n) {
        if(n<=0) {
            return 0;
        }
        return n%10 + getDigitSum(n/10);
    }
}
