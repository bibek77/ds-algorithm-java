package com.github.bibek77.dsa.miscellaneous;

/**
 * @author bibek
 */
public class LinkedListReverseMN {

    public void reverselistMN(LinkedLists lists, int m, int n) {

        Node curr = lists.head;
        Node res = lists.head;
        int i = 1;
        while (i < m) {
            curr = curr.next;
            res = res.next;
            i++;
        }
        Node prev = new Node();
        prev.next = curr;
        while (curr != null && i <= n) {
            Node tempNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNode;
            i++;
        }
        res.next = prev;
        lists.head = res;
    }
}
