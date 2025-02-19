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
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        queue.add(root);

        if(root == null) return ans;

        while(queue.size() > 0){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size > 0){
                TreeNode rem = queue.remove();

                list.add(rem.val);

                if(rem.left != null) queue.add(rem.left);
                if(rem.right != null) queue.add(rem.right);

                size--;
            }
            ans.add(list);
        }

        return ans;
    }
}