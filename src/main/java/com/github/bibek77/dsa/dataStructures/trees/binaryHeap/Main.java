package com.github.bibek77.dsa.dataStructures.trees.binaryHeap;

/**
 * @author bibek
 */
public class Main {
    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap(5);
        binaryHeap.insert(10, "min");
        binaryHeap.insert(5, "min");
        binaryHeap.insert(15, "min");
        binaryHeap.insert(1, "min");

        binaryHeap.traversal();
        binaryHeap.extractHeadOfBinaryHeap("min");

//        System.out.println(binaryHeap.peek());
//        binaryHeap.sizeOfBinaryHeap();
        binaryHeap.traversal();
    }
}
