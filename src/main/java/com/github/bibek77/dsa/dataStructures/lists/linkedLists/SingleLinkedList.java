package com.github.bibek77.dsa.dataStructures.lists.linkedLists;

/**
 * @author bibek
 */
public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createSingleLinkedList(int nodeValue) {
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;

        return head;
    }

    public void insertIntoLinkedList(int nodeValue, int address) {
        Node node = new Node();
        node.value = nodeValue;

        if (head == null) {
            createSingleLinkedList(nodeValue);
            return;
        } else if (address == 0) {
            // adding node at the first place
            node.next = head;
            // head is just an address of 1st node.
            head = node;
            // head will now have new node address.
        } else if (address >= size) {
            // inserting at the end of LL.
            node.next = null;
            // tail is the last valid node. tail has a null address
            // tail is now pointed to new node
            tail.next = node;
            // hence new node now becomes the tail.
            tail = node;
        } else {
            // temp node is declared as node is inserted in the middle as per address.
            Node tempNode = new Node();
            int index = 0;
            // iterate from 1st to until the location to insert
            while (index < address - 1) {
                tempNode = tempNode.next;
                index += 1;
            }
            // now insert at the next address as we skipped the previous address
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size += 1;
    }
    //Single LL Traversal

    public void traverseSinglyLinkedList() {
        if (head == null) {
            System.out.println("SLL is Empty");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("\n");
    }

    //Searching in a SLL
    boolean searchNode(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found the node at address: " + i + "\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    public void deleteFromList(int location) {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        } else if (location == 0) {     // Delete from the end of a list.
            head = head.next;
            size -= 1;
            if (size == 0) {
                tail = null;
            }
        } else if (location >= size) {      // Delete from the end of a list.
            Node tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head) {
                head = tail = null;
                size -= 1;
                return;
            }
            tempNode.next = null;
            tail = tempNode;
            size -= 1;

        } else {    // Delete from any position in a list.
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            // tempNode next gets updated to next reference, middle reference is removed.
            tempNode.next = tempNode.next.next;
            size -= 1;

        }
    }

    // Deletion of Entire Single LL
    public void deleteSLL() {
        head = tail = null;
        System.out.println("SLL is Deleted Successfully.");

    }


}
