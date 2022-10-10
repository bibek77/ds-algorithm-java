package com.github.bibek77.dsa.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author bibek
 */
public class BinaryTreeLevelOrder109 {
    public static void main(String[] args) {
        TreeNode root = null;
        List<List<Integer>> lists = levelOrder(root);
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> levelList = new ArrayList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        if(root==null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode tempNode = queue.remove();
            levelList.add(tempNode.val);
            if(tempNode.left!=null) {
                queue.add(tempNode.left);
            }

            if(tempNode.right!=null) {
                queue.add(tempNode.right);
            }
        }
        finalList.add(levelList);
        return finalList;

    }
}
