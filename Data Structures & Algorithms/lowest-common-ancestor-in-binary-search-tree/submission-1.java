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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode swap = p;
            p = q;
            q = swap;
        }
        if (root.val == p.val || root.val == q.val
            || root.val > p.val && root.val < q.val) {
            return root;
        }

        return p.val < root.val 
            ? lowestCommonAncestor(root.left, p, q) 
            : lowestCommonAncestor(root.right, p, q);
    }
}
