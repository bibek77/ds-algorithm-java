package com.github.bibek77.dsa.dataStructures.stack;

/**
 * @author bibek
 */
public class MainCaller {
    public static void main(String[] args) {
        StackArrayBased stackArrayBased = new StackArrayBased();
        stackArrayBased.stack(4);
        stackArrayBased.isEmpty();
        stackArrayBased.isFull();
        stackArrayBased.push(25);
        stackArrayBased.push(26);
        stackArrayBased.push(27);
        stackArrayBased.push(28);
//        stackArrayBased.push(25);
        System.out.println(stackArrayBased.pop());
        System.out.println(stackArrayBased.peek());
        stackArrayBased.deleteStack();
    }

}
