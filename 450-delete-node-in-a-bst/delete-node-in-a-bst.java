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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        if(key < root.val){
            root.left = deleteNode(root.left , key);
            return root;
        }  
        else if(key > root.val){
            root.right = deleteNode(root.right , key);
            return root;
        }
        else{
            // root is the node to be deleted
            if(root.left == null && root.right == null) return null;
            else if(root.left != null && root.right == null){
                return root.left;
            }
            else if(root.left == null && root.right != null){
                return root.right;
            }
            else{
                // both child of root are non null
                // we will replace root with inorder successor
                
                root.val = min(root.right);
                root.right = deleteNode(root.right , root.val);
                return root;
            }
        }
    }
    
    public int min(TreeNode node){
        int ans = node.val;
        TreeNode temp = node;
        while(temp.left != null){
            temp = temp.left;
            ans = temp.val;
        }
        return ans;
    }
}