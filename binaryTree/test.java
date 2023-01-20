package binaryTree;
// import binaryTree.BT;
// import binaryTree.TreeNode;

public class test {
    
    public static void main(String[] args){
        binaryTree.BT test = new binaryTree.BT();
        System.out.println(test.toString());
        TreeNode aTree = new TreeNode(0);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        aTree.left = node1;
        aTree.right = node2;
        aTree.left.left = node3;

        // [0,2,3,1]
        // System.out.println(solution.preOrder(node3).toString());
        
    }
}
