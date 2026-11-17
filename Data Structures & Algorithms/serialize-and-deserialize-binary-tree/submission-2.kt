/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec {
    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        val builder = StringBuilder()
        fun traverse(node: TreeNode?) {
            if (node != null) {
                builder.append(node.`val`).append(';')
                traverse(node.left)
                traverse(node.right)
            } else {
                builder.append("n;")
            }
        }

        traverse(root)
        return builder.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val tokens = data.split(";")
        var index = 0
        fun build(): TreeNode? {
            if (index !in tokens.indices) return null

            val rawValue = tokens[index]
            index++
            if (rawValue == "n") return null
            
            val node = TreeNode(rawValue.toInt())
            node.left = build()
            node.right = build()
            return node
        }
        return build()
    }
}
