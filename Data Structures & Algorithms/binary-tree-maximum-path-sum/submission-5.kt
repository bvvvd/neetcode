/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxPathSum(root: TreeNode?): Int {
        root ?: return 0

        var max = Int.MIN_VALUE
        fun maxSum(node: TreeNode?): Int {
            if (node == null) return@maxSum 0

            val value = node.`val`
            val leftBranchSum = maxOf(maxSum(node.left), 0)
            val rightBranchSum = maxOf(maxSum(node.right), 0)
            val maxSegment = maxOf(leftBranchSum, rightBranchSum) + value
            max = maxOf(max, leftBranchSum + rightBranchSum + value)
            return maxSegment
        }
        maxSum(root)

        return max
    }
}
