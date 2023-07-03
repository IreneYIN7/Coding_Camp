package Recursion;

public class MaxSumBTIII {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        
        public TreeNode(int key) {
          this.key = key;
        }
    }
    
    public int maxPathSum(TreeNode root) {
    // Write your solution here
    // return: maximum possible subPath sum of the current tree from root to one of the leaf nodes
    // assume the root is not null
    // keep track of the max Sum by now
    // note: if the node < 0, ignore it. else add to the current sum. < -- this is wrong!
    // key point: 只要Current sum大于0，我就可以一直加。之后和currentMax比大小record大的。
    //            然后return的是目前的sum，Note:不是current最大的sum.
    //                                        因为有可能目前不是最大的（still >0）但是加上root.key就是最大的。
    // find the max of left and right + root.key if root.key > 0
    int[] sum = {Integer.MIN_VALUE}; 
    helper(root, sum); // pass by value; I need pass by reference;
    return sum[0];
    
  }
  
  public int helper(TreeNode root, int[] curMax){
    // base case:
    // root is null, or we are at leaf node.
    if(root == null) return 0;
    // if((root.left == null && root.right == null)){
    //   curMax[0] = root.key;
    //   return curMax[0];
    // }
    // recursion
    int leftMax = helper(root.left, curMax); // 2
    int rightMax = helper(root.right, curMax); // 6
    // recursion rule 
    // calculate current sum -- 
    // to start from current node, or continue add based on the sum of its child
    int sin = Math.max(Math.max(leftMax, rightMax), 0) + root.key;
    
    // 还需要再和原来的curMax比，防止全是负数的情况。也防止root.key < 0的情况。
    curMax[0] = Math.max(curMax[0], sin);
    return sin; // 防止它没有跳过一个node +和 ？？ 一路往上加
    
  }
    
}
