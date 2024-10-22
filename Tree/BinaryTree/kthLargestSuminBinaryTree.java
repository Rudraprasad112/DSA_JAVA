package Tree.BinaryTree;
import java.util.*;


public class kthLargestSuminBinaryTree {

    static class TreeNode{

        int val; TreeNode left; TreeNode right;
    
        public TreeNode(int val){
    
            this.val = val; this.left = null;this.right = null;
        }
    }
    
        // You are given the root of a binary tree and a positive integer k.
// 
        // The level sum in the tree is the sum of the values of the nodes that are on the same level.
// 
        // Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in the tree, return -1.
// 
        // Note that two nodes are on the same level if they have the same distance from the root.
// 
// 
// 
        // Example 1:
// 
// 
        // Input: root = [5,8,9,2,1,3,7,4,6], k = 2
        // Output: 13
        // Explanation: The level sums are the following:
        // - Level 1: 5.
        // - Level 2: 8 + 9 = 17.
        // - Level 3: 2 + 1 + 3 + 7 = 13.
        // - Level 4: 4 + 6 = 10.
        // The 2nd largest level sum is 13.
        public static void main(String[] args) {

            TreeNode root = new TreeNode(5);

            root.left = new TreeNode(8);
            root.right = new TreeNode(9);
            root.left.left = new TreeNode(2);
            root.left.left.left = new TreeNode(5);
            root.left.left.right = new TreeNode(6);
            root.left.right = new TreeNode(1);
            root.right.left = new TreeNode(3);
            root.right.right = new TreeNode(7);

            //5,8,9,2,1,3,7,4,6

            long ans =kthLargestLevelSum(root,2);

            System.out.println(ans);

        }
        public static long kthLargestLevelSum(TreeNode root, int k) {
        
            // fill the largest array
    
            Queue<TreeNode> q = new LinkedList<>();
    
            PriorityQueue<Long> pq = new PriorityQueue<>();
    
            q.add(root); int level = 0;
    
            while(!q.isEmpty()){
    
                long sum = 0; int size = q.size();
    
                while(size > 0){
    
                    TreeNode r_e = q.remove();
    
                    sum += r_e.val;
    
                    if(r_e.left != null){
    
                        q.add(r_e.left);
    
                    }
    
                    if(r_e.right != null){
    
                        q.add(r_e.right);
                    
                    }
    
                    size--;
    
                }
    
                pq.add(sum);
    
                if(pq.size() > k){
    
                    pq.remove();
    
                }
    
                level++;
    
            }
    
            return k > level ?-1 : pq.peek();
        }
}
