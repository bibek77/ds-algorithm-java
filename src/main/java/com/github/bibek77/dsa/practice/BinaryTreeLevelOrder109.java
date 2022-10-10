package com.github.bibek77.dsa.practice;

import java.util.*;

/**
 * @author bibek
 */
public class BinaryTreeLevelOrder109 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        List<List<Integer>> lists = levelOrder(root);
        lists.forEach(System.out::println);
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> levelList = new ArrayList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        if(root==null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size(), count = 0;
            levelList = new ArrayList<>();
            while(count<len) {
                TreeNode tempNode = queue.remove();
                levelList.add(tempNode.val);
                if(tempNode.left!=null) {
                    queue.add(tempNode.left);
                }

                if(tempNode.right!=null) {
                    queue.add(tempNode.right);
                }
                count++;
            }
            finalList.add(levelList);
        }
        return finalList;
    }
}