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

        fun kth(root: TreeNode?): Int {
            root?.let {
                val left = kth(it.left)
                if (left != -1) {
                    return left
                }
                if (index == k) {
                    return it.`val`
                }
                index++
                return kth(it.right)
            }

            return -1
        }

        return kth(root) 
    }
}
