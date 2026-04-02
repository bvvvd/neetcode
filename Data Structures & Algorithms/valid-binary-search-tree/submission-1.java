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
        if (root == null) {
            return true;
        }
        return depth(root, Integer.MIN_VALUE, Integer.MAX_VALUE) != -1;
    }

    private int depth(TreeNode root, int minSoFar, int maxSoFar) {
        if (root == null) {
            return 0;
        }

        if (root.val >= maxSoFar || root.val <= minSoFar) {
            return -1;
        } 

        int leftDepth = depth(root.left, minSoFar, root.val);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = depth(root.right, root.val, maxSoFar);

        return rightDepth == -1 ? -1 : Math.max(leftDepth, rightDepth) + 1;
    }
}
