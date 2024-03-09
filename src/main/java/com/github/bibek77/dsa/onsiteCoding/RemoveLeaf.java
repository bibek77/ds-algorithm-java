package com.github.bibek77.dsa.onsiteCoding;

import java.util.*;

/**
 * @author bibek
 * For a rooted tree with any arbitary number of children for each node,
 * not necessarily n-ary tree.
 * Remove all the leaf nodes, and store them in a list, this would create
 * new leaf nodes. Repeat untill all the nodes are removed
 * Conditions : Freshly created leaf nodes(node whose children are removed)
 * should not be removed just after its children are removed, unless
 * there's no other option for us, then we can remove it
 */
public class RemoveLeaf {

    Map<TreeNode, List<TreeNode>> adjMap;
    Map<TreeNode, Integer> outDegree;

    public static void main(String[] args) {
        // Level 1
        TreeNode root = new TreeNode(1);

        // Level 2
        TreeNode child1 = new TreeNode(2);
        TreeNode child2 = new TreeNode(3);
        TreeNode child3 = new TreeNode(4);
        root.child.add(child1);
        root.child.add(child2);
        root.child.add(child3);

        // Level 3
        TreeNode subChild1 = new TreeNode(5);
        TreeNode subChild2 = new TreeNode(6);
        TreeNode subChild3 = new TreeNode(7);
        TreeNode subChild4 = new TreeNode(8);
        TreeNode subChild5 = new TreeNode(9);
        TreeNode subChild6 = new TreeNode(10);
        TreeNode subChild7 = new TreeNode(11);
        TreeNode subChild8 = new TreeNode(12);

        child1.child.add(subChild1);
        child1.child.add(subChild2);
        child2.child.add(subChild3);
        child2.child.add(subChild4);
        child3.child.add(subChild5);
        child3.child.add(subChild6);
        child3.child.add(subChild7);
        child3.child.add(subChild8);


        RemoveLeaf removeLeaf = new RemoveLeaf();
        List<Integer> result = removeLeaf.removeLeaf(root);
        result.forEach(System.out::println);
    }

    public List<Integer> removeLeaf(TreeNode root) {
        adjMap = new HashMap<>();
        outDegree = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> leafQueue = new LinkedList<>();
        // Getting all the nodes mapped as a graph.
        // Calculating the out degree
        // Adding current leaf nodes to the queue;
        dfs(root, leafQueue);

        // BFS to remove the nodes
        while (!leafQueue.isEmpty()) {
            TreeNode currNode = leafQueue.poll();
            result.add(currNode.val);

            for (TreeNode adjNodes : adjMap.get(currNode)) {
                int currOutdegree = outDegree.get(adjNodes);
                currOutdegree -= 1;
                outDegree.put(adjNodes, currOutdegree);
                if (currOutdegree == 0) {
                    leafQueue.add(adjNodes);
                }
            }

            // This ensures that we have deleted the leaf node now as we have traversed it.
            // In a tree a node ensures it has only one parent. hence we can get 1st index.
            TreeNode parentNode = adjMap.get(currNode).get(0);
            parentNode.child.remove(currNode);
        }
        return result;
    }

    public void dfs(TreeNode root, Queue<TreeNode> leafQueue) {
        // Adding add the initial leaf nodes to the queue.
        List<TreeNode> children = root.child;
        if (children.isEmpty()) {
            leafQueue.add(root);
            outDegree.put(root, 0);
            return;
        }

        if (!adjMap.containsKey(root))
            adjMap.put(root, new ArrayList<>());

        for (TreeNode node : children) {
            // Creating graph linkage
            adjMap.get(root).add(node);
            if (!adjMap.containsKey(node)) {
                adjMap.put(node, new ArrayList<>());
            }
            adjMap.get(node).add(root);
            dfs(node, leafQueue);
        }
        // Creating out degree for the parent
        outDegree.put(root, outDegree.getOrDefault(root, 0) + children.size());
    }

    public static class TreeNode {
        int val;
        List<TreeNode> child;

        TreeNode(int val) {
            this.val = val;
            child = new ArrayList<>();
        }
    }
}
