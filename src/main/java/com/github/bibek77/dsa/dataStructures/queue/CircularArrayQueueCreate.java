package com.github.bibek77.dsa.dataStructures.queue;

import org.springframework.core.ReactiveTypeDescriptor;

/**
 * @author bibek
 */
public class CircularArrayQueueCreate {
    int[] arr;
    int topOfQueue;
    int beginningOfQueue;
    int size;

     public CircularArrayQueueCreate(int size) {
        this.arr = new int[size];
        this.size = size;
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("Circular Queue is successfully Created.");
    }

    // Is Empty
    public boolean isEmpty() {
         if(topOfQueue == -1) {
             System.out.println("Circular Queue is Empty.");
             return true;
         }
         return false;
    }

    // Is Full
    public boolean isFull() {
         if(topOfQueue+1 == beginningOfQueue) {
             System.out.println("Circular Queue is Full");
             return true;
         } else if (beginningOfQueue == 0 && topOfQueue+1==size) {
             System.out.println("Circular Queue is Full");
             return true;
         }
         return false;
    }

    // EnQueue

    public void enQueue(int value) {
         if(isFull()) {
             System.out.println("The Circular Queue is Full");
         } else if (isEmpty()) {
             beginningOfQueue = 0;
             topOfQueue += 1;
             arr[topOfQueue] = value;
             System.out.println("The value is successfully Inserted : " + value);
         } else {
             if(topOfQueue+1 == size) {
                 topOfQueue = 0;
             } else {
                 topOfQueue += 1;
             }
             arr[topOfQueue] = value;
             System.out.println("The value is successfully Inserted : " + value);
         }
    }

}
