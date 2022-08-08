package com.github.bibek77.dsa.dataStructures.queue;

import com.github.bibek77.dsa.dataStructures.linkedLists.SingleLinkedList;

/**
 * @author bibek
 */
public class QueueLLBased {
    SingleLinkedList singleLinkedList;

    // Create a empty Queue
    public QueueLLBased() {
        singleLinkedList = new SingleLinkedList();
        System.out.println("The Queue is successfully created.");
    }

    // Is Empty Check
    public boolean isEmpty() {
        if (singleLinkedList.head == null) {
            return true;
        }
        return false;
    }

    // Enqueue value to the Queue
    public void enQueue(int value) {
        singleLinkedList.insertIntoLinkedList(value, singleLinkedList.size);
        System.out.println("Successfully Inserted value to the Queue : " + value);
    }
}
