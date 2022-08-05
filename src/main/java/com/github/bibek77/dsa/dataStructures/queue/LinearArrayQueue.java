package com.github.bibek77.dsa.dataStructures.queue;

/**
 * @author bibek
 */
public class LinearArrayQueue {
    public static void main(String[] args) {
        LinearArrayQueueCreate linearArrayQueueCreate = new LinearArrayQueueCreate(5);
        System.out.println(linearArrayQueueCreate.isFull());
        System.out.println(linearArrayQueueCreate.isEmpty());
        linearArrayQueueCreate.enQueue(56);
    }
}
