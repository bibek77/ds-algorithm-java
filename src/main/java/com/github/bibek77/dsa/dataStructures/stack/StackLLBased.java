package com.github.bibek77.dsa.dataStructures.stack;

import com.github.bibek77.dsa.dataStructures.linkedLists.SingleLinkedList;

/**
 * @author bibek
 */
public class StackLLBased {

    SingleLinkedList singleLinkedList;

    public  StackLLBased() {
        singleLinkedList = new SingleLinkedList();
    }

    // Push Method
    public void push(int value) {
        singleLinkedList.insertIntoLinkedList(value, 0); // always insert at beginning of Linked List
        System.out.println("Inserted : " + value + " in Stack");
    }

    // isEmpty
    public boolean isEmpty() {
        if(singleLinkedList.head == null) {
            System.out.println("Stack is Empty");
            return true;
        }
        return false;
    }

}
