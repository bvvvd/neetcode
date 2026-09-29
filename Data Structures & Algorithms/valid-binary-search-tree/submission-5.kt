/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean = isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)

    private fun isValidBST(node: TreeNode?, min: Long, max: Long): Boolean {
        if (node == null) return true
        if (node.`val` <= min || node.`val` >= max) return false
        return isValidBST(node.left, min, node.`val`.toLong()) &&
               isValidBST(node.right, node.`val`.toLong(), max)
    }
}
