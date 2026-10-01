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
            node?.let{ 
                builder.append(it.`val`).append(';')
                traverse(node.left)
                traverse(node.right)
            }
            node ?: builder.append("n;")
        }
        traverse(root)
        return builder.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val tokens = data.split(";")

        var index = 0
        fun build(): TreeNode? {
            if (index > tokens.lastIndex || tokens[index] == "n") {
                index++
                return null
            }

            val root = TreeNode(tokens[index].toInt())
            index++
            root.left = build()
            root.right = build()

            return root
        }

        return build()
    }
}
