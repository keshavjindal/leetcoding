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
        list = new ArrayList<>();
        solve(root);
        
        for(int i=1; i<list.size(); i++){
            if(list.get(i) <= list.get(i - 1)){
                return false;
            }
        }
        
        return true;
    }
    
    public ArrayList<Integer> list;

    public void solve(TreeNode node){
        if(node == null) return;
        
        solve(node.left);
        list.add(node.val);
        solve(node.right);
    }
}