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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(queue.size() > 0){
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while(size > 0){
                TreeNode rem = queue.remove();

                temp.add(rem.val);

                if(rem.left != null) queue.add(rem.left);
                if(rem.right != null) queue.add(rem.right);

                size--;
            }
            ans.add(temp);
        }

        return ans;
    }
}