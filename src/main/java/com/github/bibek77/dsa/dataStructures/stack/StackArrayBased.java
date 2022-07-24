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
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if(top == stack.length-1) {
            return true;
        }
        return false;
    }

    public void push(int num) {
        if(isFull()) {
            System.out.println("Stack is full");
        } else  {
            stack[++top] = num;
            System.out.println("Value is successfully inserted into the Stack.");
        }
    }

    public int pop() {
        int num=0;
        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        } else {
            num = stack[top--];
        }
        return num;
    }

    public int peek() {
        if(isEmpty())
            return -1;
        return stack[top];
    }

    public void deleteStack() {
        stack = null;
        System.out.println("Stack is successfully deleted.");
    }

}
