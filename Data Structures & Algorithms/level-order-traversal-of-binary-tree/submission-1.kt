/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val treeLevels = mutableListOf<List<Int>>()
        root?.let {
            val currentLevel = mutableListOf<TreeNode>()

            currentLevel.add(it)

            while (currentLevel.isNotEmpty()) {
                val size = currentLevel.size
                val currentLevelValues = mutableListOf<Int>()
                
                for (i in 0 until size) {
                    val node = currentLevel.first()
                    currentLevel.removeFirst()

                    currentLevelValues.add(node.`val`)
                    node.left?.let { child -> currentLevel.add(child) }
                    node.right?.let { child -> currentLevel.add(child) }
                }

                treeLevels.add(currentLevelValues)
            }
        }

        return treeLevels
    }
}
