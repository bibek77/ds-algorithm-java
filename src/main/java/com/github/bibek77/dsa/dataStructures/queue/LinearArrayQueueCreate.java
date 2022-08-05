package com.github.bibek77.dsa.dataStructures.queue;

/**
 * @author bibek
 */
public class LinearArrayQueueCreate {
    int[] arr;
    int topOfQueue;
    int beginningOfQueue;

    public LinearArrayQueueCreate(int size) {
        this.arr = new int[size];
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("Queue is created with the size : " + size);
    }

    // IsFull
    public boolean isFull() {
        if (topOfQueue == arr.length - 1) {
            return true;
        }
        return false;
    }

    // IsEmpty
    public boolean isEmpty() {
        if (beginningOfQueue == -1 || beginningOfQueue == arr.length - 1) {
            return true;
        }
        return false;
    }

    // Insert Elements to Queue
    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (isEmpty()) {
                beginningOfQueue = 0;
            }
            topOfQueue += 1;
            arr[topOfQueue] = value;
            System.out.println("Successfully inserted : " + value);
        }
    }

}
