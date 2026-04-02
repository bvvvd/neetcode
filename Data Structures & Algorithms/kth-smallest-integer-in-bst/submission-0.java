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
    private int k;
    private int value;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        if (root == null) {
            return -1;
        }
        traverse(root);
        return value;
    }

    private void traverse(TreeNode root) {
        if (root == null || k < 1) {
            return;
        }

        traverse(root.left);
        if (k == 1) {
            value = root.val;
            k--;
            return;
        }
        k--;
        traverse(root.right);
    }
}
