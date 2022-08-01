package com.github.bibek77.dsa.dataStructures.circularLinkedLists;

/**
 * @author bibek
 */
public class CircularSingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createCircularSLL(int nodeValue) {
        Node node = new Node();
        head = new Node();
        node.value = nodeValue;
        node.next = node;   // node ref to itself as CLL
        head = node;
        tail = node;
        size = 1;
        return head;
    }

}
