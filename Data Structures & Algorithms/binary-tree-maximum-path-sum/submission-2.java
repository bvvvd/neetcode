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
    private int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return maxPath;    
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, traverse(root.left));
        int right = Math.max(0, traverse(root.right));

        maxPath = Math.max(maxPath, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
