package binaryTree;
import java.util.*;

public class ReverseBTUpDown {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        
        public TreeNode(int key) {
          this.key = key;
        }
    }

    /*
     * Given a binary tree where all the right nodes are leaf nodes, 
     * flip it upside down and turn it into a tree with left leaf nodes as the root.
     * https://app.laicode.io/app/problem/178?plan=3
     * 
     * treat left subtree as subproblem. reverse left subtree.
     * 
     *      5
     *    /        \ 
     *  reversed    10
     * 
     * 
     */

    public TreeNode reverse(TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        // recursive case:
        TreeNode newRoot = reverse(root.left);
        newRoot.left = root;
        newRoot.right = root.right;
        newRoot.left.left = null;
        newRoot.left.right = null;
        return newRoot;
    }
    
}
