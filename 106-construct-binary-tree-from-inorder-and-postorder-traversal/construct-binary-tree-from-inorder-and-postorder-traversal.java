class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;

        // Map each value to its index in the inorder array for quick lookup
        HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeHelper(inorder, postorder, 0, n - 1, 0, n - 1, inorderIndexMap);
    }

    /**
     * Recursively builds the binary tree from inorder and postorder traversals.
     *
     * @param inorder     The inorder traversal array
     * @param postorder   The postorder traversal array
     * @param inStart     Start index of the current inorder segment
     * @param inEnd       End index of the current inorder segment
     * @param postStart   Start index of the current postorder segment
     * @param postEnd     End index of the current postorder segment
     * @param indexMap    Map from node values to their indices in inorder array
     * @return            Root node of the constructed subtree
     */
    public TreeNode buildTreeHelper(int[] inorder, int[] postorder,
                                    int inStart, int inEnd,
                                    int postStart, int postEnd,
                                    HashMap<Integer, Integer> indexMap) {
        if (inStart > inEnd || postStart > postEnd) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = indexMap.get(rootVal);
        int rightTreeSize = inEnd - rootIndex;

        root.left = buildTreeHelper(inorder, postorder,
                inStart, rootIndex - 1,
                postStart, postEnd - rightTreeSize - 1,
                indexMap);

        root.right = buildTreeHelper(inorder, postorder,
                rootIndex + 1, inEnd,
                postEnd - rightTreeSize, postEnd - 1,
                indexMap);

        return root;
    }
}
