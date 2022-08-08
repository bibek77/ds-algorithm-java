package com.github.bibek77.dsa.dataStructures.queue;

/**
 * @author bibek
 */
public class QueueLLBasedImplement {
    public static void main(String[] args) {
        QueueLLBased queueLLBased = new QueueLLBased();
        queueLLBased.enQueue(32);
        queueLLBased.enQueue(23);
        queueLLBased.enQueue(45);
        System.out.println(queueLLBased.isEmpty());
        System.out.println(queueLLBased.deQueue());
//        System.out.println(queueLLBased.deQueue());
        System.out.println(queueLLBased.peek());
        queueLLBased.deleteQueue();
    }
}
