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

    public void insertCSSL(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            createCircularSLL(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
            tail.next = head; // circle completed
        } else if (location >= size) {
            tail.next = node; // last node next reference to new node
            tail = node;   // last node is set to new node
            tail.next = head;  // last node next ref to head, as last node is new node
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            node.next = tempNode.next;
            tempNode.next = node;
            size += 1;
        }
    }

}
