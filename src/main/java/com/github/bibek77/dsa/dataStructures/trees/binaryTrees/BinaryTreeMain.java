package com.github.bibek77.dsa.dataStructures.trees.binaryTrees;

/**
 * @author bibek
 */
public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTreeLL binaryTreeLL = new BinaryTreeLL();
        BinaryNode N1 = new BinaryNode();
        N1.value = "N1";
        BinaryNode N2 = new BinaryNode();
        N2.value = "N2";
        BinaryNode N3 = new BinaryNode();
        N3.value = "N3";
        BinaryNode N4 = new BinaryNode();
        N4.value = "N4";
        BinaryNode N5 = new BinaryNode();
        N5.value = "N5";
        BinaryNode N6 = new BinaryNode();
        N6.value = "N6";
        BinaryNode N7 = new BinaryNode();
        N7.value = "N7";
        BinaryNode N8 = new BinaryNode();
        N8.value = "N8";
        BinaryNode N9 = new BinaryNode();
        N9.value = "N9";

        N1.left = N2;
        N1.right = N3;
        N2.left = N4;
        N2.right = N5;
        N3.left = N6;
        N3.right = N7;
        N4.left = N8;
        N4.right = N9;
        binaryTreeLL.root = N1;

        binaryTreeLL.preOrder(binaryTreeLL.root);
        System.out.println();
        binaryTreeLL.inOrder(binaryTreeLL.root);
        System.out.println();
        binaryTreeLL.postOrder(binaryTreeLL.root);
        System.out.println();
        binaryTreeLL.levelOrder(binaryTreeLL.root);
        System.out.println();
        binaryTreeLL.search("N5");
        binaryTreeLL.insert("N10");
        binaryTreeLL.levelOrder(binaryTreeLL.root);
        System.out.println();
//        binaryTreeLL.deleteDeepestNode();
        binaryTreeLL.deleteNode("N3");
        binaryTreeLL.levelOrder(binaryTreeLL.root);
        binaryTreeLL.deleteBinaryTree();
        BinaryTreeArray binaryTreeArray = new BinaryTreeArray(9);
        binaryTreeArray.insert("N1");
        binaryTreeArray.insert("N2");
        binaryTreeArray.insert("N3");
        binaryTreeArray.insert("N4");
        binaryTreeArray.insert("N5");
        binaryTreeArray.insert("N6");
        binaryTreeArray.insert("N7");
        binaryTreeArray.insert("N8");
        binaryTreeArray.insert("N9");
        binaryTreeArray.preOrder(1);
        System.out.println();
        binaryTreeArray.inOrder(1);
        System.out.println();
        binaryTreeArray.postOrder(1);
        System.out.println();
        binaryTreeArray.levelOrder(1);
        System.out.println();
        binaryTreeArray.search("N5");
        binaryTreeArray.deleteNode("N5");
        binaryTreeArray.levelOrder(1);
        binaryTreeArray.deleteBinaryTree();

    }
}
