package com.github.bibek77.dsa.dataStructures.linkedLists;

/**
 * @author bibek
 */
public class SingleLLImplement {

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.createSingleLinkedList(5);
//        System.out.println(linkedList.head.value);
        linkedList.insertIntoLinkedList(6, 1);
        linkedList.insertIntoLinkedList(7, 2);
        linkedList.insertIntoLinkedList(9, 4);
        linkedList.insertIntoLinkedList(12, 5);
        linkedList.traverseSinglyLinkedList();
        linkedList.searchNode(7);

        System.out.println("Deleting a Node ");
        linkedList.deleteFromList(3);
        linkedList.traverseSinglyLinkedList();
        linkedList.deleteSLL();
        linkedList.traverseSinglyLinkedList();
//        System.out.println(linkedList.head.next.value);
    }
}