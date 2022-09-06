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

    //insertion to CDLL
    public void insertCDLL(int nodeValue, int location) {
        DoubleLLNode newNode = new DoubleLLNode();
        newNode.value = nodeValue;
        if (head == null) {
            createCDLL(nodeValue);
            return;
        } else if (location == 0) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            head = newNode;
            tail.next = newNode;
        } else if (location >= size) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            tail = newNode;
        } else {
            DoubleLLNode tempnode = head;
            for (int i = 0; i < location - 1; i++) {
                tempnode = tempnode.next;
            }
            newNode.next = tempnode.next;
            newNode.prev = tempnode;
            tempnode.next.prev = newNode;
            tempnode.next = newNode;
        }
        size += 1;
    }

    //Traversal CDLL
    public void traverseCDLL() {
        if (head != null) {
            DoubleLLNode tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i < size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        } else {
            System.out.println("CDLL does not exists!");
        }
        System.out.println();
    }

    //Reverse Traversal of CDLL
    public void reverseTraverseCDLL() {
        if(head!=null) {
            DoubleLLNode tempNode = tail;
            for(int i=0;i<size;i++) {
                System.out.print(tempNode.value);
                if (i < size - 1) {
                    System.out.print(" <- ");
                }
                tempNode = tempNode.prev;
            }
        } else {
            System.out.println("CDLL does not exits!");
        }
        System.out.println();
    }
}
