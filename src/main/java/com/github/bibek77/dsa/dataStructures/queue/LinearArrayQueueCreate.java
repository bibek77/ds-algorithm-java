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

    // De Queue
    public int deQueue() {
        int result = -1;
        if (isEmpty()) {
            System.out.println("The Queue is empty.");
            return result;
        } else {
            result = arr[beginningOfQueue];
            beginningOfQueue++;
            if (beginningOfQueue > topOfQueue) {
                beginningOfQueue = topOfQueue = -1;
            }
        }
        return result;
    }

    // Peek
    public int peek() {
        if(!isEmpty()) {
            return arr[beginningOfQueue];
        } else {
            System.out.println("Queue is Empty.");
            return -1;
        }
    }

    // Delete the Queue
    public void deleteQueue() {
        arr = null;
        System.out.println("Queue is successfully Deleted.");
    }

}
