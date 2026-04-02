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

    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    private int goodNodes(TreeNode root, int maxSoFar) {
        if (root == null) {
            return 0;
        }

        int max = Math.max(maxSoFar, root.val);
        int goodChildren = goodNodes(root.right, max) + goodNodes(root.left, max);

        return goodChildren + (maxSoFar <= root.val ? 1 : 0);
    }
}
