package Recursion;
import java.util.*;

public class lca_V {

   public class KnaryTreeNode {
    int key;
    List<KnaryTreeNode> children;
    public KnaryTreeNode(int key) {
        this.key = key;
        this.children = new ArrayList<>();
    }
    }
    /**
     * Given two nodes in a K-nary tree, find their lowest common ancestor.
     * using recursion
     * recursion result returns: either a (means subtree has a) or b (means subtree has b) 
     * or null (means the subtree no a or b) or lca (menas subtree has a and b)
     */
    public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
        // corner case
        if(root == null || a == null || b == null) return null;
        if(root == a || root == b) return root;
        KnaryTreeNode found = null;
        for(KnaryTreeNode node: root.children){
            KnaryTreeNode lca = lowestCommonAncestor(node, a, b); // get the lca of child
            if(lca == null){
                continue;
            }
            // subtree has a or b or (a and b)
            if(found == null) found = lca; // found a or b or both
            else return root; // in the same tree level , find a and b, so return root
        }
        return found;
    }
    
}
