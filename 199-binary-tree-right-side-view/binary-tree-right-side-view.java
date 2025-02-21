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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null) return list;

        // level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size() > 0){
            int size = queue.size();

            while(size > 0){
                TreeNode rem = queue.remove();

                if(size == 1) list.add(rem.val);

                if(rem.left != null) queue.add(rem.left);
                if(rem.right != null) queue.add(rem.right);
                
                size--;
            }
        }

        return list;
    }
}