/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val inorderIndices = mutableMapOf<Int, Int>()
        inorder.forEachIndexed{ index, num -> inorderIndices[num] = index }
        var preorderIndex = 0

        fun buildTree(left: Int, right: Int): TreeNode? {
            if (left > right) {
                return null
            }
            
            val value = preorder[preorderIndex]
            preorderIndex++
            val inorderIndex = inorderIndices[value]!!
            val root = TreeNode(value)
            root.left = buildTree(left, inorderIndex - 1)
            root.right = buildTree(inorderIndex + 1, right)
            return root
        }

        return buildTree(0, inorder.lastIndex)
    }
}
