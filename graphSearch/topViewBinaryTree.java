package graphSearch;
import java.util.*;

public class topViewBinaryTree {
    public class TreeNode {
      public int key;
      public TreeNode left;
      public TreeNode right;
      
      public TreeNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
      }
    }
    
    public class Pair{
        int index;
        TreeNode node;
        Pair(TreeNode node, int indexVal){
          this.index = indexVal;
          this.node = node;
        }
    }
    public List<Integer> topView(TreeNode root) {
      //corner case
      
      if(root == null) return new ArrayList<Integer>();
      // use deque to record result from left to right.
      // if the node is the left side, then put it in the front of the deque,
      // if the node is the right side, put it in the end of the deque
  
      // record the leftmost, rightmost index
      Deque<Integer> resultDeque = new ArrayDeque<>(); // count as output no SC
      
      // using BFS 
      Deque<Pair> queue = new ArrayDeque<>();
      queue.offer(new Pair(root, 0)); // set column idx of root as 0
      resultDeque.offerFirst(root.key);
      int rightMost = 0, leftMost = 0;
      while(!queue.isEmpty()){
        int size = queue.size();
        for(int i =0; i < size; i++){
          Pair cur = queue.poll();
          int curIndex = cur.index;
          TreeNode curNode = cur.node;
          // childIndex < leftMose || childIndex > rightMost , add to resultDeque
          if(curIndex < leftMost) {
            resultDeque.offerFirst(curNode.key);
            leftMost = curIndex;
          }
          else if(curIndex > rightMost){
            resultDeque.offerLast(curNode.key);
            rightMost = curIndex;
          }
          // next level
          if(curNode.left != null) queue.offer(new Pair(curNode.left, curIndex - 1));
          if(curNode.right != null) queue.offer(new Pair(curNode.right, curIndex + 1));
        }
        
      }
  
      //handle result
      List<Integer> result = new ArrayList<>();
      while(!resultDeque.isEmpty()){
        result.add(resultDeque.pollFirst());
      }
      return result;
    }

    public static void main(String[] args){

    }
}
