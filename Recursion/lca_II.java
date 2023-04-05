package Recursion;

public class lca_II {
    // LCA with parent pointer
    // laicode: https://app.laicode.io/app/problem/127?plan=3
    // without giving root, give the parent of the target node.
    // 可以用recursion做，但是没必要，之所以要有parent应该是为了避免使用stack -> improve SC

    public class TreeNodeP {
        public int key;
        public TreeNodeP left;
        public TreeNodeP right;
        public TreeNodeP parent;
        public TreeNodeP(int key, TreeNodeP parent) {
            this.key = key;
            this.parent = parent;
        }
    }

    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
        // Write your solution here.
        // conner: 
        if(one == null || two == null) return null;
        if(one == two) return one;
        int l1 = height(one);
        int l2 = height(two);
        if(l1 > l2){
          return getCommon(two, one, l1-l2);
        }
        else{
          return getCommon(one, two, l2-l1);
        }
      }
    
      private TreeNodeP getCommon(TreeNodeP shorter, TreeNodeP longer, int diff){
        // get common parent
        while(diff > 0){
          longer = longer.parent;
          diff--;
        }
        while(shorter != longer){
          shorter = shorter.parent;
          longer = longer.parent;
        }
        return longer;
      }
      private int height(TreeNodeP node){
        //get the current height
        int height = 0;
        while(node != null){
          height ++;
          node = node.parent;
        }
        return height;
      }
    
      // TC: O(n)
      // SC: O(1)
      
    // public static void main (String arg[]){
    //     lca_II sol = new lca_II();
    // }
    
}
