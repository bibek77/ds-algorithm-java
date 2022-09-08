package com.github.bibek77.dsa.miscellaneous;

/**
 * @author bibek
 */
public class LinkedLists {
    public Node head;
    public Node tail;
    public int size;


    public void createLL(int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        head = newNode;
        tail = newNode;
        size += 1;
    }

    public void insertNodeLL(int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        tail.next = newNode;
        tail = newNode;
        size += 1;
    }

    public void traverseLL() {
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            System.out.print(tempNode.value);
            if (i < size - 1) {
                System.out.print(" -> ");
            }
            tempNode = tempNode.next;
        }
        System.out.println();
    }
}
