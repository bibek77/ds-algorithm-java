package com.github.bibek77.dsa.dataStructures.trees.simpleTrees;

import java.util.ArrayList;

/**
 * @author bibek
 */
public class TreeNode {
    String data;
    ArrayList<TreeNode> children;

    public TreeNode(String data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode node) {
        this.children.add(node);
    }

    public String display(int level) {
        String res;
        res = "  ".repeat(level) + data + "\n";
        for (TreeNode node : children) {
            res += node.display(level + 1);
        }
        return res;
    }

}
