/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        return root?.let {
            val right = invertTree(it.right)
            val left = invertTree(it.left)

            it.left = right
            it.right = left

            it
        }
    }
}
