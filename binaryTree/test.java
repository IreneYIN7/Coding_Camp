package binaryTree;
// import binaryTree.BT;
// import binaryTree.TreeNode;

public class test {
    public static void main(String[] args){
        BT atest = new BT();
        TreeNode aTree = new TreeNode(0);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        aTree.left = node1;
        aTree.right = node2;
        aTree.left.left = node3;
        System.out.println(atest.preOrderIterative(aTree).toString());
        System.out.println(atest.preOrder(aTree).toString());
        System.out.println(atest.inOrder(aTree).toString());
        System.out.println(atest.inOrderIterative(aTree).toString());
        System.out.println(atest.postOrder(aTree).toString());
        System.out.println(atest.postOrderIterative(aTree).toString());

    }

}

