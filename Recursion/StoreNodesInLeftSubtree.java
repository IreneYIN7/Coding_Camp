package Recursion;
import java.util.*;

public class StoreNodesInLeftSubtree {
    public class TreeNodeLeft {
        public int key;
        public TreeNodeLeft left;
        public TreeNodeLeft right;
        public int numNodesLeft;
        public TreeNodeLeft(int key) {
          this.key = key;
        }
    }
    /**
     * Given a binary tree, count the number of nodes in each node’s left subtree, 
     * and store it in the numNodesLeft field.
     * 
     * 
     * subproblem: the num of all nodes in the left subtree of root.
     *             Then assign the number into numNodesLeft
     * 
     */
    public void numNodesLeft(TreeNodeLeft root) {
        // base case:
        if(root.left == null) root.numNodesLeft = 0;
        countNodes(root);
    }

    private int countNodes(TreeNodeLeft root){
        if(root == null) return 0;
        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);
        root.numNodesLeft = leftNum;
        return leftNum + rightNum + 1;  // we need to keep track of all nodes of the subtree. 
        // Altho we don't need assign the number of rightSubtree to anywhere.
    }
    
}
