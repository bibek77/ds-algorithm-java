package com.github.bibek77.dsa.dataStructures.trees.binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bibek
 */
public class BinaryTreeLL {
    BinaryNode root;

    public BinaryTreeLL() {
        this.root = null;
    }

    // Pre Order Traversal
    void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // In Order Traversal
    void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    // Post Order Traversal
    void postOrder(BinaryNode node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    // Level order Traversal
    void levelOrder(BinaryNode node) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        // For level order add the values to the queue
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

    // Binary search operation
    public void search(String value) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode currNode = queue.remove();
            if (currNode.value.equalsIgnoreCase(value)) {
                System.out.println("The value is found in the tree : " + value);
                return;
            } else {
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }
        System.out.println("The value is not found in the tree : " + value);
    }
}
