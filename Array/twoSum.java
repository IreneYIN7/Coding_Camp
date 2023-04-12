package Array;
import java.util.*;

public class twoSum {
    /**
     * Determine if there exist two elements in a given array, 
     * the sum of which is the given target number.
     */

    public boolean existSum(int[] array, int target) {
        // corner case:
        if(array == null || array.length == 0) return false;
        if(array.length == 1 && array[0] != target) return false;
        if(array.length == 1 && array[0] == target) return true;
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while( left < right){
            if(array[left] + array[right] == target) return true;
            else if(array[left] + array[right] < target) left ++;
            else right--;
        }
        return false;
    
    }


    /*
     * Two sum in binary search tree
     */
    private class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int key;
        // public TreeNode(int key) {
        //     this.key = key;
        // }

    }

    /*
     *        4
             / \
            2    5
          /  \
        1     3
     */

    public boolean exsitSumBST2(TreeNode root, int target){
        Set<Integer> set = new HashSet<>();
        return find(root, target, set);
    }

    private boolean find(TreeNode root, int target, Set<Integer> set){
        // target = k + p ; find if p exist where k = root.key
        if(root == null) return false;
        if(set.contains(target - root.key)) return true; // if p exist
        set.add(root.key);
        return find(root.left, target, set) || find(root.right, target, set); // check if left subtree has p, or right subtree has p
        // note: if one is at left subtree and the other is at right subtree, it's okay, since we record visited node in set.

    }

    
    
}
