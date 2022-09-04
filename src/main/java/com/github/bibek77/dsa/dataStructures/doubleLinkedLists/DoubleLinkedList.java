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
        size = 1;
        return head;
    }

    // Insertion Method
    public void insertDLL(int nodeValue, int location) {
        DoubleLLNode newNode = new DoubleLLNode();
        newNode.value = nodeValue;
        if (head == null) {
            createDLL(nodeValue);
            return;
        } else if (location == 0) {
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        } else if (location >= size) {
            newNode.next = null;
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            DoubleLLNode tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index += 1;
            }
            newNode.prev = tempNode;
            newNode.next = tempNode.next;
            tempNode.next.prev = newNode;
            tempNode.next = newNode;
        }
        size += 1;
    }

    //Traversal Method
    public void traverseDll() {
        if (head != null) {
            DoubleLLNode tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        } else {
            System.out.println("DLL does not exist");
        }
        System.out.println();
    }

    //reverse traversal
    public void reverseTraverseDll() {
        if (head != null) {
            DoubleLLNode tempNode = tail;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" <- ");
                }
                tempNode = tempNode.prev;
            }
        } else {
            System.out.println("DLL is empty");
        }
        System.out.println();
    }

    //Searching in a Double Linked List
    public boolean searchDll(int nodeValue) {
        if (head != null) {
            DoubleLLNode tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("NodeValue : " + nodeValue + " found at : " + (i + 1) + " position");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found!");
        return false;
    }

    //Delete a node in a DLL
    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("DLL does not exist!");
            return;
        } else if (location == 0) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
        } else if (location >= size) {
            DoubleLLNode tempNode = tail.prev;
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                tempNode.next = null;
                tail = tempNode;
            }
            size--;
        } else {
            DoubleLLNode tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            size--;
        }
    }


}
