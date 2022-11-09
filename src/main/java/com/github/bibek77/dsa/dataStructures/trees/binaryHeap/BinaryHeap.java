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
        for (int i = 1; i <= sizeOfHeap; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //Heapify Method Bottom to Top
    public void heapifyBottomToTop(int index, String heapType) {
        int parent = index / 2; // for left or right node it will give root index
        if (index <= 1) {
            return;
        }
        if (heapType.equalsIgnoreCase("min")) {
            if (arr[index] < arr[parent]) {
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        } else if (heapType.equalsIgnoreCase("max")) {
            if (arr[index] > arr[parent]) {
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }
        // Recursively calling method for all the parent
        heapifyBottomToTop(parent, heapType);
    }

    //Heapify Top to Bottom
    public void heapifyTopToBottom(int index, String heapType) {
        int left = 2 * index;
        int right = (2 * index) + 1;
        int swapChild = 0;
        if (sizeOfHeap < left) {
            return;
        }
        if (heapType.equalsIgnoreCase("max")) {
            if (sizeOfHeap == left) {
                if (arr[index] < arr[left]) {
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            } else { // size of heap is having right child index
                if (arr[left] > arr[right]) {
                    swapChild = left;
                } else {
                    swapChild = right;
                }
                if (arr[index] < arr[swapChild]) {
                    int temp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = temp;
                }
            }
        } else if (heapType.equalsIgnoreCase("min")) {
            if (sizeOfHeap == left) {
                if (arr[index] > arr[left]) {
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            } else { // size of heap is having right child index
                if (arr[left] < arr[right]) {
                    swapChild = left;
                } else {
                    swapChild = right;
                }
                if (arr[index] > arr[swapChild]) {
                    int temp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = temp;
                }
            }
        }
        heapifyTopToBottom(swapChild, heapType);

    }

    public void insert(int value, String heapType) {
        arr[sizeOfHeap + 1] = value;
        sizeOfHeap += 1;
        heapifyBottomToTop(sizeOfHeap, heapType);
        System.out.println("Value is successfully Inserted.");
    }

    // Extract head of heap
    public int extractHeadOfBinaryHeap(String heapType) {
        int extractValue = -1;
        if (isEmpty()) {
            return extractValue;
        } else {
            extractValue = arr[1];
            arr[1] = arr[sizeOfHeap];
            sizeOfHeap--;
            heapifyTopToBottom(1, heapType);
        }
        return extractValue;
    }
}
