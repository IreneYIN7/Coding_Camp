package Recursion;

import java.util.*;

public class lca_I {

    private class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int key;
        public TreeNode(int key) {
            this.key = key;
        }

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        // tree+ recursion
        // check conner case
        if(root == null || one == null || two == null) return null;
        // base case:
        if(root == two || root == one) return root;
        // recursion
        TreeNode lc = lowestCommonAncestor(root.left, one, two);
        TreeNode rc = lowestCommonAncestor(root.right, one, two);
        // recursive rules
        // if lc == null && rc == null return null; --> this case is impossible.
        // if lc != null && rc != null return root;
        // if lc == null || rc == null return not null;
        if(lc == null && rc == null) return root;
        return (lc !=null)? lc : rc;

    }

    
    
}
