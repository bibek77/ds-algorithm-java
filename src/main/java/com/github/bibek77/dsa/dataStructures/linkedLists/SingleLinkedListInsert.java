package com.github.bibek77.dsa.dataStructures.linkedLists;

/**
 * @author bibek
 */
public class SingleLinkedListInsert {
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


}
