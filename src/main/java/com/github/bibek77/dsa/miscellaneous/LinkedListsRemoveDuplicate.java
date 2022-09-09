package com.github.bibek77.dsa.miscellaneous;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bibek
 */
public class LinkedListsRemoveDuplicate {

    public void deleteDups(LinkedLists list) {
        Set<Integer> set = new HashSet<>();
        Node curr = new Node();

        curr = list.head;
        Node prev = new Node();
        prev.next = curr;
        while (curr != null) {
            if (!set.add(curr.value)) {
                prev.next = curr.next;
                list.size--;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
    }

}
