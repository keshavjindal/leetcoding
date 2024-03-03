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
    public boolean isValidBST(TreeNode root) {
        return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean solve(TreeNode node, long min, long max){
        if(node == null) return true;
        
        boolean x = min <= node.val && node.val <= max;
        boolean y = solve(node.left, min, (long)node.val - 1);
        boolean z = solve(node.right, (long)node.val + 1, max);
        
        return x && y && z;
    }
}