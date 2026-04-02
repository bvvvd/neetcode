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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderValues = new ArrayList<>();
        traverse(root, inorderValues);
        return inorderValues;
    }

    private void traverse(TreeNode root, List<Integer> values) {
        if (root != null) {
            traverse(root.left, values);
            values.add(root.val);
            traverse(root.right, values);
        }
    }
}