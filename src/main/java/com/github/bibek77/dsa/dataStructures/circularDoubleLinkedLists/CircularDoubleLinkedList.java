package com.github.bibek77.dsa.dataStructures.circularDoubleLinkedLists;

/**
 * @author bibek
 */
public class CircularDoubleLinkedList {
    public DoubleLLNode head;
    public DoubleLLNode tail;
    public int size;

    //create CDLL
    public DoubleLLNode createCDLL(int nodeValue) {
        head = new DoubleLLNode();
        DoubleLLNode newNode = new DoubleLLNode();
        newNode.value = nodeValue;
        head = newNode;
        tail = newNode;
        newNode.next = newNode;
        newNode.prev = newNode;
        size = 1;
        return head;
    }
}
