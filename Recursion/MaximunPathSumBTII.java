package Recursion;

import java.security.Principal;
import java.util.*;

public class MaximunPathSumBTII {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        
        public TreeNode(int key) {
          this.key = key;
        }
    }
    /**
     * Given a binary tree in which each node contains an integer number. 
     * Find the maximum possible sum from any node to any node (the start node and the end node can be the same). 
     *    -1
        /    \
       2      11
             /  \
            6   -14
    one example of paths could be -14 -> 11 -> -1 -> 2
    another example could be the node 11 itself
    The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18

    note: we don't really need to outpout a "single path", if any subtree is negative, we can just treat it as 0. 
        It not about real path, but the sum!!
        eg : the left subtree of -1, we have left subsubtree is -14, just treat as 0, the sum would be 6 + 11 + 0.

     * idea: if the subtree is < 0 , then ignore. 
     * 
     * @param root the root of the binary tree
     * @return the maximum possible sum from any node to any node
     */
    public int maxPathSum(TreeNode root) {
        // corner case:
        if(root == null) return Integer.MIN_VALUE; // clarify 
        // int maxSum = Integer.MIN_VALUE; // You can't use int value here. Pass by value won't effect the value outside the function.
        int[] maxSum = new int[] {Integer.MIN_VALUE};
        maxPathSumHeper(root, maxSum);
        return maxSum[0];
    }

    // return the max of the subtree's "single path"
    private int maxPathSumHeper(TreeNode root, int[] maxSum){
        // base case:
        if(root == null) return 0;
        // if(root.left == null && root.right == null){    <-- this is not the base case!!
        //     maxSum[0] = Math.max(maxSum[0], root.key);
        //     return root.key;
        // }
        // recursive rule:
        int leftSum = maxPathSumHeper(root.left, maxSum);
        int rightSum = maxPathSumHeper(root.right, maxSum);
        leftSum = (leftSum < 0)? 0 : leftSum;
        rightSum = (rightSum < 0)? 0 : rightSum;
        maxSum[0] = Math.max(root.key + leftSum + rightSum, maxSum[0]);
        return root.key + Math.max(leftSum, rightSum);
    }

    /* the element inside of paren is the return value of helper function
     *    -1(16) -> maxSum = [18]
        /    \
       2(2)   11(17)
             /  \
            6(6) 1(1)
     */

    public static void main(String[] args){
        MaximunPathSumBTII sol = new MaximunPathSumBTII();
        TreeNode a = sol.new TreeNode(-1);
        TreeNode b = sol.new TreeNode(2);
        TreeNode c = sol.new TreeNode(11);
        TreeNode d = sol.new TreeNode(6);
        TreeNode e = sol.new TreeNode(-14);
        TreeNode b1 = sol.new TreeNode(10);
        TreeNode b2 = sol.new TreeNode(-1);
        TreeNode b3 = sol.new TreeNode(9);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        b.left = b1;
        b1.left = b2;
        b2.right = b3;
        /** sum = 17 + -1 + 20 
         *    -1
            /    \
           2      11
          /     /  \
         10    6   -14
         /
        -1
          \
          9

         */
        System.out.println("max sum: " + sol.maxPathSum(a));
    }
   
}
