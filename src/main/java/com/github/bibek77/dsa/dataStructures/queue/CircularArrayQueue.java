package com.github.bibek77.dsa.dataStructures.queue;

/**
 * @author bibek
 */
public class CircularArrayQueue {
    public static void main(String[] args) {
        CircularArrayQueueCreate circularArrayQueueCreate = new CircularArrayQueueCreate(3);
        circularArrayQueueCreate.isEmpty();
        circularArrayQueueCreate.isFull();
        circularArrayQueueCreate.enQueue(45);
        circularArrayQueueCreate.enQueue(51);
        circularArrayQueueCreate.enQueue(15);
        circularArrayQueueCreate.enQueue(23);
        System.out.println(circularArrayQueueCreate.deQueue());
        System.out.println(circularArrayQueueCreate.peek());
        circularArrayQueueCreate.deleteQueue();
    }
}
