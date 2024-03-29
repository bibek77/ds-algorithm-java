package com.github.bibek77.dsa.dataStructures.lists.doubleLinkedLists;

/**
 * @author bibek
 */
public class DoubleLLImplement {
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.createDLL(1);
        dll.insertDLL(2, 0);
        dll.insertDLL(3, 1);
        dll.insertDLL(3, 7);
        System.out.println(dll.head.next.value);
        dll.traverseDll();
        dll.reverseTraverseDll();
        dll.searchDll(1);
        dll.deleteNode(0);
        dll.traverseDll();
        dll.deleteDll();
    }
}
