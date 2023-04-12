package Recursion;
import java.util.*;

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;


public class lca_III {
    private class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int key;
        public TreeNode(int key) {
            this.key = key;
        }

    }
    /**
     * Given two nodes in a binary tree, find their lowest common ancestor (the given two nodes are not guaranteed to be in the binary tree).
     * Return null If any of the nodes is not in the tree.
     * sol1: tranverse binary tree - in order - in hashSet to check if one and two exist
     *       if both exist, do the lca for binary tree
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        if(root == null || one == null || two == null) return null;
        HashSet<TreeNode> treeNodes = new HashSet<>();
        traverseInOrder(root, treeNodes);
        if(treeNodes.contains(one) && treeNodes.contains(two)){
            // do the lca check
            return lca(root, one, two);
        }
        return null;

    }

    private TreeNode lca(TreeNode root, TreeNode one, TreeNode two){
        if(root == null || root == one || root == two) return root;
        TreeNode lc = lca(root.left, one, two);
        TreeNode rc = lca(root.right, one, two);
        if(lc != null && rc != null) return root;
        return (lc != null)? lc : rc;
    }

    private void traverseInOrder(TreeNode root, HashSet<TreeNode> treeNodes){
        // tree won't be empty
        if(root == null) return;
        traverseInOrder(root.left, treeNodes);
        treeNodes.add(root);
        traverseInOrder(root.right, treeNodes);
    }
    
}
// traverse in order: tc: O(n), sc: O(height)

// tc: O(n) +  O(n) = O(n)
// sc: O(height)