package com.github.bibek77.dsa.dataStructures.queue;

/**
 * @author bibek
 */
public class QueueLinearArray {
    public static void main(String[] args) {
        QueueLinearArrayCreate linearArrayQueueCreate = new QueueLinearArrayCreate(5);
        System.out.println(linearArrayQueueCreate.isFull());
        System.out.println(linearArrayQueueCreate.isEmpty());
        linearArrayQueueCreate.enQueue(56);
        linearArrayQueueCreate.enQueue(46);
        linearArrayQueueCreate.enQueue(36);
        System.out.println(linearArrayQueueCreate.deQueue());
        System.out.println(linearArrayQueueCreate.deQueue());
        System.out.println(linearArrayQueueCreate.peek());
        linearArrayQueueCreate.deleteQueue();
    }
}
