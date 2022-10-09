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

    //Minimum node
    public BinaryNode minimumNode(BinaryNode root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumNode(root.left);
        }
    }

    // Delete Node
    public BinaryNode deleteNode(BinaryNode root, int value) {
        if (root == null) {
            System.out.println("Value not found in BST");
            return null;
        }
        if (value < root.value) {
            // call recursively on the left child
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            // calling recursively on right child
            root.right = deleteNode(root.right, value);
        } else {
            // When the value matches the node (root is just node representation)
            // We check for 3 cases
            // Current Node is leaf, Current Node has 1 child, Current Node has 2 children.
            if (root.left != null && root.right != null) {
                // 1st scenario, Current is root or parent Node
                BinaryNode temp = root;
                // find minimum node from right subtree
                BinaryNode minNodeForRight = minimumNode(temp.right);
                // update root value with min value from right
                root.value = minNodeForRight.value;
                // then delete the min value from right subtree
                root.right = deleteNode(root.right, minNodeForRight.value);
            } else if (root.left != null) {
                // 2nd scenario , having one child (left)
                root = root.left;
            } else if (root.right != null) {
                // 2nd scenario , having one child (right)
                root = root.right;
            } else {
                // 3rd scenario, having no child, we can delete the node.
                root = null;
            }
        }
        return root;
    }

    // Delete Entire BST
    public void deleteBST() {
        root = null;
        System.out.println("BST is deleted successfully");
    }

}
