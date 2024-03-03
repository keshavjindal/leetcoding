/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
        return solve(root.left , root.right); 
    }
    
    public boolean solve(TreeNode one, TreeNode two){
        if(one == null && two == null) return true;
        if(one == null && two != null) return false;
        if(one != null && two == null) return false;
        
        boolean x = one.val == two.val;
        boolean y = solve(one.left , two.right);
        boolean z = solve(one.right , two.left);
        
        return x && y && z;
    }
}