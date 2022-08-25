package com.github.bibek77.dsa.dataStructures.doubleLinkedLists;

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
    }
}
