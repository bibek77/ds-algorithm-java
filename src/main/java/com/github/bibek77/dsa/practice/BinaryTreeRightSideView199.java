package com.github.bibek77.dsa.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author bibek
 */
public class BinaryTreeRightSideView199 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        List<Integer> lists = levelOrder(root);
        lists.forEach(System.out::println);
    }
    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> finalView = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null)
            return new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size(), count=0;
            TreeNode tempNode = null;
            while(count<len) {
                tempNode = queue.remove();
                if(tempNode.left!=null)
                    queue.add(tempNode.left);
                if(tempNode.right!=null)
                    queue.add(tempNode.right);
                count++;
            }
            finalView.add(tempNode.val);
        }
        return finalView;
    }
}