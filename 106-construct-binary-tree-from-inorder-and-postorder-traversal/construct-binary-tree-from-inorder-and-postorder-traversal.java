class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i] , i);
        }

        return buildTreeHelper(inorder, postorder, 0, n - 1, 0, n - 1, map);
    }

    /**
     * Helper function to build subtree using in and post arrays
     * @param isi : inorder start index
     * @param iei : inorder end index 
     * @param psi : postorder start index
     * @param pei : postorder end index
     */
    public TreeNode buildTreeHelper(int[] in, int[] post, int isi, int iei, int psi, int pei, HashMap<Integer,Integer> map){
        if(isi > iei || psi > pei) return null;

        TreeNode root = new TreeNode(post[pei]);

        int idx = map.get(post[pei]);
        int eleInRightSubtree = iei - idx;
        
        root.left = buildTreeHelper(in, post, isi, idx - 1, psi, pei - eleInRightSubtree - 1, map);
        root.right = buildTreeHelper(in, post, idx + 1, iei, pei - eleInRightSubtree, pei - 1, map);

        return root;
    }

    /**
    inorder =       [9,3,15,20,7]
    postorder =     [9,15,7,20,3]
    
    
     */
}