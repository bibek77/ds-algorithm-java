package com.github.bibek77.dsa.practice;

import java.util.*;

/**
 * @author bibek
 */
public class BinaryTreeRightSideView199 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        List<Integer> lists = levelOrder(root);
        lists.forEach(System.out::println);
        lists = new ArrayList<>();
        lists = dfs(root, 0, lists);
        lists.forEach(System.out::println);
    }

    // Using Level Order Traversal
    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> finalView = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size(), count = 0;
            TreeNode tempNode = null;
            while (count < len) {
                // If count is equal to length them we are at the end of level
                tempNode = queue.remove();
                if (tempNode.left != null)
                    queue.add(tempNode.left);
                if (tempNode.right != null)
                    queue.add(tempNode.right);
                count++;
            }
            finalView.add(tempNode.val);
        }
        return finalView;
    }

    //Using Pre/Post/In Order Traversal
    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> finalView = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        if(root==null)
            return new ArrayList<>();
        stk.push(root);
        while(!stk.empty()) {

            TreeNode tempNode = stk.pop();
            if(tempNode.left!=null)
                stk.push(tempNode.left);
            if(tempNode.right!=null)
                stk.push(tempNode.right);
            finalView.add(tempNode.val);
        }

        return finalView;
    }

    //DFS using recursion algorithm
    public static List<Integer> dfs(TreeNode root, int currentLevel, List<Integer> finalView) {

        if(root==null) {
            return new ArrayList<>();
        }
        if(currentLevel>=finalView.size()){
            finalView.add(root.val);
        }
        if(root.right!=null)
            dfs(root.right, currentLevel+1, finalView);
        if(root.left!=null)
            dfs(root.left, currentLevel+1, finalView);
        return finalView;
    }
}