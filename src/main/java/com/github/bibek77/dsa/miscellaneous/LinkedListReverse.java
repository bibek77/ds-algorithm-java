package com.github.bibek77.dsa.miscellaneous;

/**
 * @author bibek
 */
public class LinkedListReverse {

    public void reverseList(LinkedLists lists) {
        Node curr = lists.head;
        Node prev = new Node();
        prev.next = curr;
        while(curr!=null) {
            Node tempNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNode;
        }
        lists.head = prev;
    }
}
