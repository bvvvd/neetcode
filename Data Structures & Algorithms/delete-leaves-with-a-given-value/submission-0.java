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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (remove(root, target)) {
            return null;
        }

        return root;
    }

    private boolean remove(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        if (remove(root.left, target)) {
            root.left = null;
        }
        if (remove(root.right, target)) {
            root.right = null;
        }

        return root.val == target && root.left == null && root.right == null;
    }
}
