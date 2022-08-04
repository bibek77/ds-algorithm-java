package com.github.bibek77.dsa.dataStructures.stack;

/**
 * @author bibek
 */
public class StackLLBasedImplement {
    public static void main(String[] args) {
        StackLLBased stackLLBased = new StackLLBased();
        stackLLBased.push(1);
        stackLLBased.push(2);
        stackLLBased.push(3);
//        stackLLBased.isEmpty();
        System.out.println(stackLLBased.pop());
        System.out.println(stackLLBased.peek());
        stackLLBased.deleteStack();
    }
}
