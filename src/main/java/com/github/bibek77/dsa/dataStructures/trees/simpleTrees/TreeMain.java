package com.github.bibek77.dsa.dataStructures.trees.simpleTrees;

/**
 * @author bibek
 */
public class TreeMain {
    public static void main(String[] args) {
        TreeNode drinks = new TreeNode("Drinks");
        TreeNode hot = new TreeNode("Hot");
        TreeNode cold = new TreeNode("Cold");
        drinks.addChild(hot);
        drinks.addChild(cold);
        TreeNode tea = new TreeNode("tea");
        TreeNode coffee = new TreeNode("Coffee");
        TreeNode wine = new TreeNode("Wine");
        TreeNode beer = new TreeNode("Beer");
        hot.addChild(tea);
        hot.addChild(coffee);
        cold.addChild(beer);
        cold.addChild(wine);
        System.out.println(drinks.display(0));

    }
}
