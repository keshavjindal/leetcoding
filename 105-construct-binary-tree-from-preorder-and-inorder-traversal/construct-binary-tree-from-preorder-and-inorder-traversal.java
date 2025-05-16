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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder: NODE LEFT RIGHT
        // inorder: LEFT NODE RIGHT

        /**
        
        pre: 3 9 20 15 7
         in: 9 3 15 20 7
        

        idx - isi
         */

        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i] , i);
        }

        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

    }

    public HashMap<Integer,Integer> map;

    public TreeNode helper(int[] pre, int[] in, int psi, int pei, int isi, int iei){
        if(pei < psi || iei < isi){
            return null;
        }

        TreeNode root = new TreeNode(pre[psi]);

        int idx = map.get(pre[psi]);

        root.left = helper(pre , in , psi + 1 , psi + idx - isi , isi , idx - 1);
        root.right = helper(pre , in , psi + idx - isi + 1 , pei , idx + 1 , iei);
    
        return root;
    }


}