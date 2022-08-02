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
        }
        size += 1;
    }

    // Traverse Circular Single Linked List
    public void traverseCSLL() {

        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
            System.out.println();
        } else {
            System.out.println("Circular SLL Doesn't exists");
        }
    }

    // Search Single linked list
    public boolean searchCSLL(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found Node at Location : " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node is not Found in List.");
        return false;
    }

    // Delete CSLL
    public void deleteCSLL(int location) {
        if (head == null) {
            System.out.println("Linked list is Empty");
        } else if (location == 0) {
            head = head.next;
            tail.next = head;
            size -= 1;
            if (size == 0) {
                tail = null;
                head.next = null;
                head = null;
            }
        } else if (location >= size) {
            Node tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head) {
                tail = head = null;
                size -= 1;
                return;
            }
            tempNode.next = head;
            tail = tempNode;
            size -= 1;
        } else {
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size -= 1;
        }
    }

}
