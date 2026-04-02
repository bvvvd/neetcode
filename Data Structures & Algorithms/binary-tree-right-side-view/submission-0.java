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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<>();
        dfs(root, rightSideView, 0);
        return rightSideView;
    }

    private void dfs(TreeNode root, List<Integer> rightSideView, int level) {
        if (root != null) {
            if (level == rightSideView.size()) {
                rightSideView.add(root.val);
            }

            dfs(root.right, rightSideView, level + 1);
            dfs(root.left, rightSideView, level + 1);
        }
    }
}
