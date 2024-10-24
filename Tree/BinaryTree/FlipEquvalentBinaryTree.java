package Tree.BinaryTree;

import Tree.BinaryTree.kthLargestSuminBinaryTree.TreeNode;

public class FlipEquvalentBinaryTree {
    
    public static void main(String[] args) {
       // in this problem given two binary tree .
       // trees are diff 
       // swap left ro right in root1 after swap cheack the two trees are equvalent

       // construct a  two binary tree two cheack binary tree
    //    TreeNode root = new TreeNode(5);

    //    root.left = new TreeNode(8);
    //    root.right = new TreeNode(9);
    //    root.left.left = new TreeNode(2);
    //    root.left.left.left = new TreeNode(5);
    //    root.left.left.right = new TreeNode(6);
    //    root.left.right = new TreeNode(1);
    //    root.right.left = new TreeNode(3);
    //    root.right.right = new TreeNode(7);

    }
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        
        if(root1 == null && root2 == null) return true;

        if(root1 == null || root2 == null || root1.val != root2.val){

            return false;

        }

        boolean flip = false; boolean no_flip = false;

       flip = flipEquiv(root1.left,root2.left) && flipEquiv(root1.right,root2.right);

       no_flip  =flipEquiv(root1.left,root2.right) && flipEquiv(root1.right,root2.left);
       
       return  flip || no_flip;

    }
}
