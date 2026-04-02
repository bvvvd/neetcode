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

        TreeNode targetLeaf = find(root, val);
        if (targetLeaf.val < val) {
            targetLeaf.right = newNode;
        } else {
            targetLeaf.left = newNode;
        }

        return root;
    }

    private TreeNode find(TreeNode root, int val) {
        if (root.val < val) {
            if (root.right == null) {
                return root;
            } else {
                return find(root.right, val);
            }
        } else {
            if (root.left == null) {
                return root;
            } else {
                return find(root.left, val);
            }
        }
    }
}