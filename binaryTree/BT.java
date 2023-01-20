package binaryTree;
import java.util.*;

public class BT  {
    private int size;
    private TreeNode rootNode;

    public BT(){
        this.size = 0;
        this.rootNode = null;
    }
    public BT(int key){
        this.size = 1;
        this.rootNode = new TreeNode(key);
    }

    /*
    PreOrder Traversal Recursion
    TC: O(n)
    SC: O(height)
     */
    public List<Integer> preOrder(TreeNode root){
        if(root == null) return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<>();
        preOrderhelper(result, root);
        return result;
    }
    private void preOrderhelper(List<Integer> orderList, TreeNode root){
        if(root == null) return;
        orderList.add(root.key);
        preOrderhelper(orderList, root.left);
        preOrderhelper(orderList, root.right);
    }
    /*
    PreOrder Traversal Iterative
    data structure used: stack (by using deque structure)
    TC: O(n)
    SC: O(height)
     */
    public List<Integer> preOrderIterative(TreeNode root){
        if(root == null) return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.offerFirst(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pollFirst();
            result.add(cur.key);
            if(cur.right != null) stack.offerFirst(cur.right);

            if(cur.left != null) stack.offerFirst(cur.left);
        }
        return result;
    }

    /*
    In-order traversal recursive
    TC: O(n)
    SC: O(height)
     */

    public List<Integer> inOrder(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<Integer>();
        inOrderhelper(result, root);
        return result;
    }
    private void inOrderhelper(List<Integer> orderList, TreeNode root){
        if(root == null) return;
        inOrderhelper(orderList,root.left);
        orderList.add(root.key);
        inOrderhelper(orderList, root.right);
    }


    /***
     * In order traversal iteratively
     *     TC: O(n)
     *     SC: O(height)
     *  Need a helper to keep track if the left as already visited
     * @param root treeNode root
     * @return a list of in order node value
     */
    public List<Integer> inOrderIterative(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode helper = root;
        while(!stack.isEmpty() || helper != null){
            if(helper != null){
                stack.offerFirst(helper);
                helper = helper.left;
            }
            else{
                TreeNode cur = stack.pollFirst();
                result.add(cur.key);
                helper = cur.right;   // 错误点
            }

        }
        return result;
    }

    /***
     * Post-Order traversal recursively
     * O(n)
     * O(height)
     * @param root treenode root
     * @return a list with post order node int value
     */
    public List<Integer> postOrder(TreeNode root){
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        postOrderHelper(result, root);
        return result;
    }

    private void postOrderHelper(List<Integer> result, TreeNode root){
        if(root == null) return;
        postOrderHelper(result, root.left);
        postOrderHelper(result, root.right);
        result.add(root.key);
    }

    /***
     * postOrder Traversal recursively
     * need to create prev and cur to see its position in order to determine which state it's at.
     * Data structure needed: Stack LIFO
     * Initial: Prev= null and cur = root
     * if prev.left == cur  or prev.right == cur or prev = null, we still need to explore left, append to stack
     * if cur.left = prev, then we've already visited left, and now go to visit right subtree
     * if cur.right = prev, then we need to visit left and right subtree, pop and go up;
     *     1
     *    / \
     *   2   3
     *   [1
     *   prev = 1
     *   cur = 3
     *
     * @param root TreeNode root
     * @return a list of post order node value
     */
    public List<Integer> postOrderIterative(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode prev = null;
        stack.offerFirst(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.peekFirst();
            if(prev == null || prev.left == cur || prev.right == cur){
                if(cur.left != null) stack.offerFirst(cur.left);
                else if(cur.right != null) stack.offerFirst(cur.right);
                else {
                    result.add(stack.pollFirst().key);
                }
            }
            else if(cur.left == prev){ // left tree has already been visited
                if(cur.right!= null) stack.offerFirst((cur.right));
            }
            else {//if(prev == cur.right)
                result.add(stack.pollFirst().key);
            }
            prev = cur;
        }
        return result;
    }

    public List<List<Integer>> layerByLayer(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        // ArrayList<ArrayList<Integer>>()
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> layer = new ArrayList<Integer>();
            int length = queue.size();
            for(int i = 0; i< length; i++){
                TreeNode cur = queue.poll();
                if(cur.left!= null) queue.offer(cur.left);
                if(cur.right!= null) queue.offer(cur.right);
                layer.add(cur.key);
            }
            result.add(layer);
        }
        return result;
    }
    public String toString(){
        return "hello";
    }

}
