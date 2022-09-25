package com.github.bibek77.dsa.practice;

import java.util.Stack;

/**
 * @author bibek
 */
public class ValidParanthesis20 {

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(validParanthesis(s));
    }

    private static boolean validParanthesis(String s) {
        Stack<Character> stk = new Stack<>();
        char[] chr = s.toCharArray();
        int i=0, len = s.length();
        if (len==0)
            return true;
        while(i<len) {
            if(stk.empty()) {
                stk.push(chr[i]);
            } else {
                if(chr[i]==')' && stk.peek().equals('(')) {
                    stk.pop();
                } else if (chr[i]=='}' && stk.peek().equals('{')) {
                    stk.pop();
                } else if (chr[i]==']' && stk.peek().equals('[')) {
                    stk.pop();
                } else {
                    stk.push(chr[i]);
                }
            }
            i++;
        }
        if(stk.empty())
            return true;
        return  false;
    }
}
