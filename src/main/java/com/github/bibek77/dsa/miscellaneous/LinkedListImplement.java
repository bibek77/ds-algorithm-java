package com.github.bibek77.dsa.miscellaneous;

/**
 * @author bibek
 */
public class LinkedListImplement {
    public static void main(String[] args) {
        LinkedLists ll = new LinkedLists();
        ll.createLL(1);
        ll.insertNodeLL(9);
        ll.insertNodeLL(5);
        ll.insertNodeLL(10);
        ll.insertNodeLL(2);
        ll.traverseLL();
        LinkedListsRemoveDuplicate linkedListsRemoveDuplicate = new LinkedListsRemoveDuplicate();
//        linkedListsRemoveDuplicate.deleteDups(ll);
        LinkedListsNthToLast linkedListsNthToLast = new LinkedListsNthToLast();
//        int num = linkedListsNthToLast.nthToLast(ll, 5);
//        int numTwoPointer = linkedListsNthToLast.nthToLastTwoPointer(ll, 5);
//        System.out.println(num);
//        System.out.println(numTwoPointer);
        ll.traverseLL();
        LinkedListsPartition linkedListsPartition = new LinkedListsPartition();
        linkedListsPartition.partition(ll, 4);
        ll.traverseLL();
    }

}
