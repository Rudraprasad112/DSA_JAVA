package Tree.BinaryTree;

import Tree.BinaryTree.kthLargestSuminBinaryTree.TreeNode;

public class CosineBinaryTree {
    public static void main(String[] args) {
       //Given the root of a binary tree, replace the value of each node in the tree with the sum of all its cousins' values.
       // Two nodes of a binary tree are cousins if they have the same depth with different parents.

       // Return the root of the modified tree.

        //Note that the depth of a node is the number of edges in the path from the root node to it.

        // ceate a binary tree to find the answer
        
            TreeNode root = new TreeNode(5);

            root.left = new TreeNode(8);
            root.right = new TreeNode(9);
            root.left.left = new TreeNode(2);
            root.left.left.left = new TreeNode(5);
            root.left.left.right = new TreeNode(6);
            root.left.right = new TreeNode(1);
            root.right.left = new TreeNode(3);
            root.right.right = new TreeNode(7);

            TreeNode ans = replaceValueInTree(root);

    }
    public static TreeNode replaceValueInTree(TreeNode root) {
        
        dfs(new TreeNode [] {root});

        root.val = 0;

        return root;

    }
    public static  void dfs(TreeNode arr[]){

        if(arr.length == 0){

            return ;
        }

        int sum = 0;

        for(TreeNode temp :arr){

            if(temp == null) continue;

            if(temp.left != null){

                sum += temp.left.val;

            }
            if(temp.right != null){

                sum += temp.right.val;

            }

        }
        //avoid same root node's child and add diff root child nodes val

        TreeNode []copy = new TreeNode [arr.length * 2]; // one root at most two child only

        int idx = 0;

        for( TreeNode node:arr){

            if(node == null) continue;

            int curr_sum = 0;

            if(node.left != null) curr_sum += node.left.val;

            if(node.right != null) curr_sum += node.right.val;

            if(node.left != null){

                node.left.val = sum - curr_sum;

                copy[idx++] = node.left;

            }
            if(node.right != null){

                node.right.val = sum - curr_sum;

                copy[idx++] = node.right;

            }
        }

        dfs(java.util.Arrays.copyOf(copy,idx));


    }

}
