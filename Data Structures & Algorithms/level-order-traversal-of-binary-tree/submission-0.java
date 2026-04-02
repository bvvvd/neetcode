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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> level = new LinkedList<>();
            level.add(root);

            while (!level.isEmpty()) {
                int levelSize = level.size();

                List<Integer> levelValues = new ArrayList<>();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = level.poll();

                    if (node.left != null) {
                        level.add(node.left);
                    }
                    if (node.right != null) {
                        level.add(node.right);
                    }

                    levelValues.add(node.val);
                }

                levels.add(levelValues);
            }
        }
        return levels;
    }
}
