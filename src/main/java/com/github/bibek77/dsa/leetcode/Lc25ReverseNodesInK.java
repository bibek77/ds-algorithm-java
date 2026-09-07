package com.github.bibek77.dsa.leetcode;

/**
 * @author bibek
 */
public class Lc25ReverseNodesInK {

    //  Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k <= 1)
                return head;

            ListNode result = new ListNode(-1);
            result.next = head;
            ListNode prevTail = result;

            ListNode start = head;
            ListNode end = head;

            int i = 1;
            while (true) {
                while (i <= k && end != null) {
                    end = end.next;
                    i++;
                }

                if (i <= k) { // exit if remaining nodes are less than k
                    break;
                }

                // prev tail will always hold the last node of the k th run, i.e 1 before end, till which start travels.
                // So once rever sal of a block is done it can be added to next ok k
                // i.e : 2 -> 1 (prevTail) -> from reverse(4 -> 3 -> null)
                prevTail.next = reverse(start, end);

                // This connect is must as once start (1 -> 2) is reversed, 2 -> 1 -> null
                // It will point to null and list is disconnected, so connect it to end i.e 2 -> 1 -> 3....
                // then move start to end
                start.next = end;
                prevTail = start;
                start = end;
                i = 1;
            }

            return result.next;

        }

        public ListNode reverse(ListNode start, ListNode end) {

            ListNode curr = start;
            ListNode prev = null;
            // if  we assign prev as null after reverse it looks like
            // 2->1 -> null and this is return when k=2 , first run
            // so this is a partial diconnected list, where last node points to null
            while (curr != end && curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            return prev;

        }
    }
}
