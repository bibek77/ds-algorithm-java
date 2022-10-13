package com.github.bibek77.dsa.practice;

/**
 * @author bibek
 */
public class ValidBinarySeachTree98 {
        public boolean isValidBST(TreeNode root) {
            if(root==null)
                return true;
            return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
        public boolean dfs(TreeNode node, long min, long max) {
            if(node.val <= min || node.val >= max)
                return false;

            if(node.left!=null) {
                if(!dfs(node.left, min, node.val)) {
                    return false;
                }
            }
            if(node.right!=null) {
                if(!dfs(node.right, node.val, max)) {
                    return false;
                }

            }
            return true;
        }
}
