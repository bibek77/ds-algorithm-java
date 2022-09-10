package com.github.bibek77.dsa.miscellaneous;

/**
 * @author bibek
 */
public class LinkedListsNthToLast {

    public int nthToLast(LinkedLists list, int n) {
        int i=0;
        Node curr = new Node();
        curr = list.head;
        if (list.size-n < 0)
            return -1;
        while(i < list.size-n) {
            curr = curr.next;
            i++;
        }
        return curr.value;
    }
}
