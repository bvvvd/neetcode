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
    private Map<Integer, Integer> inorderIndexes = new HashMap<>();
    private int[] preorder;
    private int rootIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexes.put(inorder[i], i);
        }

        return build(0, inorder.length - 1);
    }

    private TreeNode build(int left, int right) {
        if (rootIndex >= preorder.length || left > right) {
            return null;
        }

        int rootValue = preorder[rootIndex];
        rootIndex++;
        TreeNode root = new TreeNode(rootValue);
        root.left = build(left, inorderIndexes.get(rootValue) - 1);
        root.right = build(inorderIndexes.get(rootValue) + 1, right);

        return root;
    }
}
