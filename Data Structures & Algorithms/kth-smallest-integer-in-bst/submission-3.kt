/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        var index = 1

        fun kth(node: TreeNode?): Int? {
            node ?: return null
            kth(node.left)?.let { return it }
            if (index == k) return node.`val`
            index++
            return kth(node.right)
        }

        return kth(root)!!
    }
}
