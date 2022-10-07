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

    //Insertion Method
    void insert(String value) {
        BinaryNode node = new BinaryNode();
        node.value = value;
        if (root == null) {
            root = node;
            System.out.println("Inserted at root");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode currNode = queue.remove();
            if (currNode.left == null) {
                currNode.left = node;
                System.out.println("Inserted at Left Child");
                break;
            } else if (currNode.right == null) {
                currNode.right = node;
                System.out.println("Inserted at Right Child");
                break;
            } else {
                queue.add(currNode.left);
                queue.add(currNode.right);
            }
        }
    }

    /**
     * Deleting a Node from a Binary Tree
     *
     * @implNote Find the Node, Find Deepest Node, Set Deepest Node value to the node to be deleted
     * Then delete Deepest Node
     */
    // Get the Deepest Node
    public BinaryNode getDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode currNode = null;
        while (!queue.isEmpty()) {
            currNode = queue.remove();
            if (currNode.left != null) {
                queue.add(currNode.left);
            }
            if (currNode.right != null) {
                queue.add(currNode.right);
            }
        }
        return currNode;
    }

    //Delete Deepest Node
    public void deleteDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode prevNode, currNode = null;
        while (!queue.isEmpty()) {
            prevNode = currNode;
            currNode = queue.remove();
            if (currNode.left == null) {
                prevNode.right = null;
                return;
            } else if (currNode.right == null) {
                currNode.left = null;
                return;
            }
            queue.add(currNode.left);
            queue.add(currNode.right);
        }
    }

    // Delete Node
    void deleteNode(String value) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode currNode = queue.remove();
            if (currNode.value == value) {
                currNode.value = getDeepestNode().value;
                deleteDeepestNode();
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
        System.out.println("Node does not exists in Binary Tree");
    }

    // Delete binary tree
    void deleteBinaryTree() {
        root = null;
        System.out.println("Binary tree has been successfully deleted");
    }
}
