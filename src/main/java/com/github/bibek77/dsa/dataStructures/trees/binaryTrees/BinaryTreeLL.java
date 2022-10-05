package com.github.bibek77.dsa.dataStructures.trees.binaryTrees;

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
}
