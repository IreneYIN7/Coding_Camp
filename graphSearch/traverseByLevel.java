package graphSearch;
import java.util.*;
public class traverseByLevel {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        
        public TreeNode(int key) {
          this.key = key;
        }
    }
    
    // traverse the tree level by level
    public List<List<Integer>> layerBylayer(TreeNode root){
        // corner case:
        if(root == null) return new ArrayList<List<Integer>>();

        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offerFirst(root);

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        while(!queue.isEmpty()){
            List<Integer> curLevel = new ArrayList<>();
            int size = queue.size(); // note!!! the queue size would change while you add ele in.
            // have to first store the size of the queue and then add new level.
            for(int i = 0; i < size; i ++){
                TreeNode curNode = queue.pollLast();
                curLevel.add(curNode.key);
                if(curNode.left != null) queue.offerFirst(curNode.left);
                if(curNode.right != null) queue.offerFirst(curNode.right);
            }
            result.add(curLevel);
        }
        return result;

    }

    public static void main(String[] args){
        traverseByLevel sol = new traverseByLevel();
        TreeNode tree = sol.new TreeNode(5);
        tree.left = sol.new TreeNode(8);
        tree.right = sol.new TreeNode(3);
        
        System.out.println(sol.layerBylayer(tree).toString());
    }
    
}
