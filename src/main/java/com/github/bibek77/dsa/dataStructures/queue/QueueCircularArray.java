package com.github.bibek77.dsa.dataStructures.queue;

/**
 * @author bibek
 */
public class QueueCircularArray {
    public static void main(String[] args) {
        QueueCircularArrayCreate circularArrayQueueCreate = new QueueCircularArrayCreate(3);
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
