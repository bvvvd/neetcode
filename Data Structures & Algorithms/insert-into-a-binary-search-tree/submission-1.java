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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            return newNode;
        }
        
        TreeNode parent = find(root, val);
        if (parent.val < val) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }

        return root;
    }

    private TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val < val) {
            return root.right == null ? root : find(root.right, val);
        }

        return root.left == null ? root : find(root.left, val);
    }
}