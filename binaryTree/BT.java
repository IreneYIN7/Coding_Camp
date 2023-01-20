package binaryTree;
import java.util.*;

// import binaryTree.binaryTree.*;

public class BT {
    public int size;
    public TreeNode root;
    public BT(){
        this.size = 0;
        this.root = null;
    }

    public BT(int key){
        this.size = 1;
        this.root = new TreeNode(key);
    }
    public String toString(){
        return "hello";
    }

}
   
