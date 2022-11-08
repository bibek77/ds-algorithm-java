package com.github.bibek77.dsa.dataStructures.trees.binaryHeap;

/**
 * @author bibek
 */
public class BinaryHeap {
    int arr[];
    int sizeOfHeap;

    public BinaryHeap(int size) {
        arr = new int[size];
        this.sizeOfHeap = 0;
        System.out.println("Binary Heap has been created !");
    }

    public boolean isEmpty() {
        if (sizeOfHeap == 0)
            return true;
        return false;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Binary Heap is Empty.");
            return -1;
        }
        return arr[1];
    }

    public int sizeOfBinaryHeap() {
        return sizeOfHeap;
    }

    public void traversal() {
        for (int i = 1; i < sizeOfHeap; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
