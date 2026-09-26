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
            val left = it.left
            val right = it.right

            it.left = invertTree(right)
            it.right = invertTree(left)

            it
        }
    }
}
