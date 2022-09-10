package com.github.bibek77.dsa.miscellaneous;

/**
 * @author bibek
 */
public class LinkedListImplement {
    public static void main(String[] args) {
        LinkedLists ll = new LinkedLists();
        ll.createLL(3);
        ll.insertNodeLL(4);
        ll.insertNodeLL(1);
        ll.insertNodeLL(3);
        ll.insertNodeLL(6);
        ll.traverseLL();
        LinkedListsRemoveDuplicate linkedListsRemoveDuplicate = new LinkedListsRemoveDuplicate();
//        linkedListsRemoveDuplicate.deleteDups(ll);
        LinkedListsNthToLast linkedListsNthToLast = new LinkedListsNthToLast();
        int num = linkedListsNthToLast.nthToLast(ll, 5);
        int numTwoPointer = linkedListsNthToLast.nthToLastTwoPointer(ll, 5);
        System.out.println(num);
        System.out.println(numTwoPointer);
        ll.traverseLL();
    }

}
