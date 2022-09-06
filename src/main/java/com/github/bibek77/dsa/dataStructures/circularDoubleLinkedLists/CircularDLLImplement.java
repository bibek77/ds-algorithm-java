package com.github.bibek77.dsa.dataStructures.circularDoubleLinkedLists;

/**
 * @author bibek
 */
public class CircularDLLImplement {
    public static void main(String[] args) {
        CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
        cdll.createCDLL(1);
        System.out.println(cdll.head.value);
        cdll.insertCDLL(4, 0);
        cdll.insertCDLL(7, 1);
        cdll.insertCDLL(2, 1);
        cdll.insertCDLL(5, 4);
        System.out.println(cdll.head.value);
        cdll.traverseCDLL();
        cdll.reverseTraverseCDLL();
        cdll.searchCDLL(2);
        cdll.deleteNodeCDLL(2);
        cdll.traverseCDLL();
        cdll.deleteCDLL();
    }
}
