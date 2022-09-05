package com.github.bibek77.dsa.dataStructures.circularDoubleLinkedLists;

/**
 * @author bibek
 */
public class CircularDLLImplement {
    public static void main(String[] args) {
        CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
        cdll.createCDLL(1);
        System.out.println(cdll.head.value);
    }
}
