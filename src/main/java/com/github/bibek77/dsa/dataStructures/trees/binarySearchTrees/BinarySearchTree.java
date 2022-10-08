package com.github.bibek77.dsa.dataStructures.trees.binarySearchTrees;

/**
 * @author bibek
 */
public class BinarySearchTree {
    BinaryNode root;

    public BinarySearchTree() {
        root = null;
    }

    //Insert Method
    private BinaryNode insert(BinaryNode currentNode, int value) {
        if (currentNode == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            System.out.println("Value successfully inserted at root");
            return  newNode;
        } else if (value <= currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }

    void insert(int value) {
        insert(root, value);
    }
}
