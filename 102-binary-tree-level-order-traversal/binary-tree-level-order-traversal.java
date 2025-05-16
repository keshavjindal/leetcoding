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

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        while(queue.size() > 0){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while(size > 0){
                TreeNode rem = queue.removeFirst();

                temp.add(rem.val);

                if(rem.left != null) queue.addLast(rem.left);
                if(rem.right != null) queue.addLast(rem.right);

                size--;
            }
            ans.add(temp);
        }

        return ans;
    }
}