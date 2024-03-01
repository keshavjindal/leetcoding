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
    public int diameterOfBinaryTree(TreeNode root) {
        pair p = solve(root);
        return p.dia;
    }
    
    public pair solve(TreeNode node){
        if(node == null){
            return new pair(0 , -1);  
        }
        
        pair left = solve(node.left);
        pair right = solve(node.right);
        
        int mrdia = Math.max(Math.max(left.dia , right.dia) , left.ht + right.ht + 2);
        int mrht = Math.max(left.ht , right.ht) + 1;
        
        return new pair(mrdia , mrht);
    }
    
    public class pair{
        int dia; // diameter
        int ht; // height in terms of edges
        
        pair(int dia, int ht){
            this.dia = dia;
            this.ht = ht;
        }
    }
}