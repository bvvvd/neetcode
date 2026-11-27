class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val root = TrieNode()
        for (word in words) {
            var node = root
            for (c in word) {
                node = node.children.getOrPut(c) { TrieNode() }
            }
            node.isWord = true
        }

        val foundWords = mutableListOf<String>()
        val path = StringBuilder()
        fun backtrack(i: Int, j: Int, parent: TrieNode) {
            if (i !in board.indices || j !in board[i].indices || board[i][j] == '.') return
            val c = board[i][j]
            val node = parent.children[c] ?: return
            path.append(c)
            if (node.isWord) {
                foundWords.add(path.toString())
                node.isWord = false
            }

            board[i][j] = '.'
            backtrack(i - 1, j, node)
            backtrack(i + 1, j, node)
            backtrack(i, j - 1, node)
            backtrack(i, j + 1, node)
            board[i][j] = c

            path.deleteCharAt(path.lastIndex)
            if (node.children.isEmpty()) parent.children.remove(c)
        }
        for (i in board.indices) {
            for (j in board[i].indices) {
                backtrack(i, j, root)
            }
        }
        return foundWords
    }

    class TrieNode(
        val children: MutableMap<Char, TrieNode> = mutableMapOf(),
        var isWord: Boolean = false
    )
}
