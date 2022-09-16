package com.github.bibek77.dsa.practice;

import java.util.Stack;

/**
 * @author bibek
 */
public class BackspaceString844 {
    public static void main(String[] args) {

        System.out.println(backspaceCompareBrute("ab#c", "ad#c"));
        System.out.println(backspaceCompareOptimal("ab#c", "ad#c"));

    }

    public static boolean backspaceCompareOptimal(String s, String t) {

        int i = s.length()-1;
        int j = t.length()-1;
        int skip = 0;
        char []sc = s.toCharArray();
        char []tc = t.toCharArray();
        while (true) {
            skip=0;
            while(i>=0 && (skip>0 || sc[i]=='#')) {
                skip += sc[i]=='#' ? 1:-1;
                i--;
            }
            skip=0;
            while(j>=0 && (skip>0 || tc[j]=='#')) {
                skip += tc[j]=='#' ? 1:-1;
                j--;
            }
            if(i>=0 && j>=0 && sc[i]==tc[j]) {
                i--;
                j--;
            } else {
                break;
            }
        }
        return i==-1 && j==-1;
    }

    public static boolean backspaceCompareBrute(String s, String t) {

        int lens = s.length();
        int lent = t.length();
        char chs[] = s.toCharArray();
        char cht[] = t.toCharArray();
        Stack<Character> stks = new Stack<>();
        Stack<Character> stkt = new Stack<>();
        int i = 0;
        while (i < lens) {
            if (chs[i] != '#')
                stks.push(chs[i]);
            else if (!stks.empty() && chs[i] == '#')
                stks.pop();
            i++;
        }
        i = 0;
        while (i < lent) {
            if (cht[i] != '#')
                stkt.push(cht[i]);
            else if (!stkt.empty() && cht[i] == '#')
                stkt.pop();
            i++;
        }
        if (stks.size() != stkt.size())
            return false;
        if (stks.equals(stkt))
            return true;
        return false;
    }
}
