package com.github.bibek77.dsa.dataStructures.trees.binaryHeap;

/**
 * @author bibek
 */
public class Main {
    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap(5);
        System.out.println(binaryHeap.peek());
        binaryHeap.sizeOfBinaryHeap();
        binaryHeap.traversal();
    }
}
