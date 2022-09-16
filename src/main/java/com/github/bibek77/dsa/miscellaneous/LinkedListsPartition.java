package com.github.bibek77.dsa.miscellaneous;

/**
 * @author bibek
 */
public class LinkedListsPartition {

    LinkedLists partition(LinkedLists ll, int x) {
        Node curr = ll.head;
        ll.tail = ll.head;
        while (curr!=null) {
            Node next = curr.next;
            if(curr.value<x) {
                curr.next = ll.head;
                ll.head = curr;
            } else {
                ll.tail.next = curr;
                ll.tail = curr;
            }
            curr = next;
        }
        ll.tail.next = null;
        return ll;
    }
}
