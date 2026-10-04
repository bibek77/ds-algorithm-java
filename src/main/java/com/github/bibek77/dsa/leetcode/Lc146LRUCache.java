package com.github.bibek77.dsa.leetcode;

/**
 * @author bibek
 */

import java.util.HashMap;
import java.util.Map;

class Lc146LRUCache {

    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    public Lc146LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity; // Fixed: added 'this.'

        // Fixed: Initialize dummy head and tail to avoid NullPointerExceptions
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node currNode = map.get(key);
            removeNode(currNode);      // Detach from current position
            insertToFront(currNode);   // Move to front
            return currNode.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            curr.value = value;
            removeNode(curr);        // Fixed: Must move to front when updated
            insertToFront(curr);
        } else {
            if (map.size() == capacity) {
                Node lru = tail.prev;    // The node right before dummy tail is the LRU
                map.remove(lru.key);     // Fixed: Remove from map using the node's key
                removeNode(lru);         // Remove from linked list
            }
            Node curr = new Node(key, value); // Fixed: Pass both key and value
            insertToFront(curr);
            map.put(key, curr);
        }
    }

    // Fixed: Now only handles insertion. Detachment is handled by removeNode().
    public void insertToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Fixed: Extracted the deletion logic into a clean remove method
    public void removeNode(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    class Node {
        int key;   // Fixed: Added key so we can remove from map during eviction
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

