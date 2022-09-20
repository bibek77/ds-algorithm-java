package com.github.bibek77.dsa.miscellaneous;

/**
 * @author bibek
 */
public class LinkedListReverseMN {

    public void reverselistMN(LinkedLists lists, int left, int right) {

        Node dummy = new Node();
        dummy.next = lists.head;
        Node prev = dummy;

        for(int i=0;i<left-1;i++) {
            prev = prev.next;
        }

        Node curr = prev.next;
        Node old = curr.next;
        for(int i=0;i<right-left;i++) {
            curr.next = old.next;
            old.next = prev.next;
            prev.next = old;
            old = curr.next;
        }
        lists.head = dummy.next;
    }
}
