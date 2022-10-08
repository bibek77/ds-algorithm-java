package com.github.bibek77.dsa.dataStructures.trees.binarySearchTrees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bibek
 */
public class BinarySearchTree {
    BinaryNode root;

    BinarySearchTree() {
        root = null;
    }

    //Insert Method
    private BinaryNode insert(BinaryNode currentNode, int value) {
        if (currentNode == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
//            System.out.println("Value successfully inserted at root");
            return newNode;
        } else if (value <= currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }

    void insert(int value) {
        root = insert(root, value);
    }

    // Pre Order traversal
    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //In Order Traversal
    public void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    //Post Order Traversal
    public void postOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    //Level Order Traversal
    public void levelOrder(BinaryNode node) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            BinaryNode currNode = queue.remove();
            System.out.print(currNode.value + " ");
            if (currNode.left != null) {
                queue.add(currNode.left);
            }
            if (currNode.right != null) {
                queue.add(currNode.right);
            }
        }
    }

    //Searching Value
    BinaryNode search(BinaryNode node, int value) {
        if (node == null) {
            System.out.println("Value doesn't exists");
            return null;
        } else if (node.value == value) {
            System.out.println("Value is found in tree");
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
        return null;
    }
}
