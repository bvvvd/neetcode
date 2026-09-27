/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val smaller = if (p!!.`val` < q!!.`val`) p else q
        val greater = if (smaller == p) q else p

        if (root?.`val` == p?.`val` || root?.`val` == q?.`val` || root!!.`val` < greater!!.`val` && root!!.`val` > smaller!!.`val`) {
            return root;
        }

        if (root!!.`val` < smaller!!.`val` && root!!.`val` < greater!!.`val`) {
            return lowestCommonAncestor(root?.right, p, q)
        } else {
            return lowestCommonAncestor(root?.left, p, q)
        }
    }
}
