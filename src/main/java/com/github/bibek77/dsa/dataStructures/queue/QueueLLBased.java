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

    // Dequeue value from the Queue
    public int deQueue() {
        int value = -1;
        if(isEmpty()) {
            return value;
        } else {
            value = singleLinkedList.head.value; // First value is captured
            singleLinkedList.deleteFromList(0); // In Queue element is deleted from the front
        }
        return value;
    }

    // Peek Element
    public int peek() {
        int value = -1;
        if(isEmpty()) {
            return -1;
        } else {
            value = singleLinkedList.head.value;
        }
        return value;
    }

    // Delete Queue
    public void deleteQueue() {
        singleLinkedList.head = null;
        singleLinkedList.tail = null;
        System.out.println("Queue is successfully deleted.");
    }
}
