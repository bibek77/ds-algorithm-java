package com.github.bibek77.dsa.dataStructures.doubleLinkedLists;

/**
 * @author bibek
 */
public class DoubleLinkedList {
    DoubleLLNode head;
    DoubleLLNode tail;
    int size;

    public DoubleLLNode createDLL(int nodeValue) {
        head = new DoubleLLNode();
        DoubleLLNode newNode = new DoubleLLNode();
        newNode.value = nodeValue;
        newNode.next = null;
        newNode.prev = null;
        head = newNode;
        tail = newNode;
        return head;
    }


}
