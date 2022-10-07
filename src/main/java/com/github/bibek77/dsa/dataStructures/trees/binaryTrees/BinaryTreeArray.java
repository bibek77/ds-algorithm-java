package com.github.bibek77.dsa.dataStructures.trees.binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bibek
 */
public class BinaryTreeArray {
    String[] arr;
    int lastUsedIndex;

    public BinaryTreeArray(int size) {
        arr = new String[size + 1];
        lastUsedIndex = 0;
        System.out.println("Blank tree is created with size : " + size);
    }

    // isFull
    boolean isFull() {
        if (arr.length - 1 == lastUsedIndex) {
            return true;
        }
        return false;
    }

    //Insert to Binary Tree
    void insert(String value) {
        if (!isFull()) {
            arr[++lastUsedIndex] = value;
            System.out.println("Node is inserted successfully : " + value);
        } else {
            System.out.println("Binary tree is Full");
        }
    }

    // Pre Order Traversal
    public void preOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        System.out.print(arr[index] + " ");
        preOrder(index * 2);
        preOrder(index * 2 + 1);
    }

    // In order Traversal
    public void inOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        inOrder(index * 2);
        System.out.print(arr[index] + " ");
        inOrder(index * 2 + 1);
    }

    // Post Order Traversal
    public void postOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        postOrder(index * 2);
        postOrder(index * 2 + 1);
        System.out.print(arr[index] + " ");
    }

    //Level Order Traversal
    public void levelOrder(int index) {
        // 2 ways
        for (int i = 1; i <= lastUsedIndex; i++) {
            System.out.print(arr[i] + " ");
        }

//        if (index > lastUsedIndex) {
//            return;
//        }
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(index);
//        while (!queue.isEmpty()) {
//            int temp = queue.remove();
//            System.out.print(arr[temp] + " ");
//            if (temp * 2 <= lastUsedIndex) {
//                queue.add(temp * 2);
//            }
//            if (temp * 2 + 1 <= lastUsedIndex) {
//                queue.add(temp * 2 + 1);
//            }
//        }
    }

    // Search in a binary Tree
    public int search(String value) {
        for (int i = 1; i <= lastUsedIndex; i++) {
            if (arr[i].equalsIgnoreCase(value)) {
                System.out.println("Value found in the Array at : " + i);
                return i;
            }
        }
        return -1;
    }

    // Delete a node in Level Order
    public void deleteNode(String value) {
        int location = search(value);
        if (location == -1)
            return;
        arr[location] = arr[lastUsedIndex];
        lastUsedIndex--;
        System.out.println("The node is successfully deleted.");
    }

    // Deleting the binary tree
    public void deleteBinaryTree() {
        try {
            arr = null;
            System.out.println("Tree is successfully deleted");
        } catch (Exception e) {
            System.out.println("Error deleting the tree");
        }
    }

}
