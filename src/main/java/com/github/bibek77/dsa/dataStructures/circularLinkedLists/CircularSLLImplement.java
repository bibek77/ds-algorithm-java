package com.github.bibek77.dsa.dataStructures.circularLinkedLists;

/**
 * @author bibek
 */
public class CircularSLLImplement {
    public static void main(String[] args) {
        CircularSingleLinkedList circularSingleLinkedList = new CircularSingleLinkedList();
        circularSingleLinkedList.createCircularSLL(7);
//        System.out.println(circularSingleLinkedList.head.value);
//        System.out.println(circularSingleLinkedList.head.next.value);
        circularSingleLinkedList.insertCSSL(4, 0);
        circularSingleLinkedList.insertCSSL(5, 1);
        circularSingleLinkedList.insertCSSL(6, 2);
        circularSingleLinkedList.insertCSSL(8, 3);
//        System.out.println(circularSingleLinkedList.head.value);
        circularSingleLinkedList.traverseCSLL();
        circularSingleLinkedList.searchCSLL(5);
        circularSingleLinkedList.deleteCSLL(2);
        circularSingleLinkedList.traverseCSLL();
    }
}
