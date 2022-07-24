package com.github.bibek77.dsa.dataStructures.stack;

/**
 * @author bibek
 */
public class StackArrayBased {
    int[] stack;
    int top;

    public void stack(int size) {
        this.stack = new int[size];
        this.top = -1;

    }

    public boolean isEmpty(){
        if(top == -1) {
            System.out.println("Stack is Empty");
            return true;
        } else {
            System.out.println("Stack is not Empty");
        }
        return false;
    }

}
