package com.github.bibek77.dsa.dataStructures.linkedLists;

/**
 * @author bibek
 */
public class SingleLLImplement {

    public static void main(String[] args) {
        SingleLinkedListInsert linkedList = new SingleLinkedListInsert();
        linkedList.createSingleLinkedList(5);
        System.out.println(linkedList.head.value);
        linkedList.insertIntoLinkedList(6, 0);
        linkedList.insertIntoLinkedList(7, 3);
        System.out.println(linkedList.head.next.value);
    }
}