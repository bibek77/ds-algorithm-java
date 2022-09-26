package com.github.bibek77.dsa.practice;

import java.util.Stack;

/**
 * @author bibek
 */
public class ValidParenthesis1249 {
    public static void main(String[] args) {
        String s = "ab(cd(e)fg)h)";
        System.out.println(minRemoveToMakeValid(s));
    }

    public static String minRemoveToMakeValid(String s) {

        String[] res = s.split("");
        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i = 0, len = s.length();
        while (i < len) {
            if (res[i].equals("(")) {
                stk.push(i);
            } else if (res[i].equals(")") && !stk.empty()) {
                stk.pop();
            } else if (res[i].equals(")")) {
                res[i] = "";
            }

            i++;
        }
        while (!stk.empty()) {
            int index = stk.pop();
            res[index] = "";
        }
        return String.join("", res);
    }
}
