package com.github.bibek77.dsa.miscellaneous;

/**
 * @author bibek
 */
public class LinkedListsNthToLast {

    public int nthToLast(LinkedLists list, int n) {
        int i = 0;
        new Node();
        Node curr = list.head;
        if (list.size - n < 0)
            return -1;
        while (i < list.size - n) {
            curr = curr.next;
            i++;
        }
        return curr.value;
    }

    public int nthToLastTwoPointer(LinkedLists lists, int n) {
        int i = 0;
        Node fast = lists.head;
        Node late = lists.head;
        while (fast != null) {
            fast = fast.next;
            if (i >= n) {
                late = late.next;
            }
            i += 1;
        }
        if (i < n)
            return -1;
        return late.value;
    }

}
