package Recursion;
import java.util.*;


public class lca_IV {
    private class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int key;
        public TreeNode(int key) {
            this.key = key;
        }

    }
    // LCA with k nodes in BT
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        // Write your solution here.
        // conner
        if(root == null) return null;
        Set<TreeNode> nodeSet = new HashSet<>(nodes);
        return lcaHelper(root, nodeSet);
        
      }
    
      private TreeNode lcaHelper(TreeNode root, Set<TreeNode> nodeSet){ 
        // has to be the general type Set<TreeNode> Since you declear the type of Set
        // if you declear nodeSet as HashSet, then you can use HasSet
        if (root == null) return null;
        if(nodeSet.contains(root)) return root;
        TreeNode lc = lcaHelper(root.left, nodeSet);
        TreeNode rc = lcaHelper(root.right, nodeSet);
        if(lc != null && rc != null) return root;
        return (lc!=null)? lc : rc;
    
    }
    // TC: O(n)
    // SC: O(h + k)
}
