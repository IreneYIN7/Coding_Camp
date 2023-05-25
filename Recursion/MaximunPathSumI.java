package Recursion;
import java.util.*;


public class MaximunPathSumI {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        
        public TreeNode(int key) {
          this.key = key;
        }
    }

    /**
     * Given a binary tree and a target sum, 
     * determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given target.
     * 
     * Note: Root-to-leaf path -> one way path
     *        5
             / \
            4   8
           /   / \
          1    3  4
         /  \      \
        7    2      1
     * 
     * return true, as there exist a root-to-leaf path 5-8-3 which sum is 16.
     * 
     * target - root.key = k
     * recursively found if the the subtree could add to that k. (can only do subtraction with root.key)
     * recursive return: if the subtree has the targetsum. 
     * 
     * Note: node value can be negative.
     * 
     * If node is a leaf, return if the the current sum is zero, 
     * i.e if the initial sum was discovered.
     * 
     */
    public boolean exist(TreeNode root, int target) {
        // base case:
        if(root == null) return false;
        target -= root.key;
        if (root.left == null && root.right == null) return target == 0;
        return exist(root.left, target) || exist(root.right, target);
    }
    
}
