package com.github.bibek77.dsa.practice;

/**
 * @author bibek
 */

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class GroupIdenticalLevel {
    public static List<List<Integer>> groupIdenticalLevels(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Map<List<Integer>, List<Integer>> levels = new LinkedHashMap<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> sequence = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                sequence.add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            levels.computeIfAbsent(sequence, k -> new ArrayList<>()).add(level);
            level++;
        }

        for(List<Integer> allLevels : levels.values()) {
            if(allLevels.size() > 1) {
                result.add(allLevels);
            }
        }
        return result;
    }
}