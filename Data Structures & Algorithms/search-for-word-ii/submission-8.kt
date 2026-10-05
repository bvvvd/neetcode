class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val trie = Trie()
        words.forEach { trie.insert(it) }

        val foundWords = mutableListOf<String>()

        fun search(i: Int, j: Int, node: TrieNode) {
    if (i !in board.indices ||
        j !in board[i].indices ||
        board[i][j] == '.'
    ) {
        return
    }

    val c = board[i][j]
    val next = node.children[c] ?: return

    board[i][j] = '.'

    if (next.word != null) {
        foundWords.add(next.word!!)
        next.word = null
    }

    search(i - 1, j, next)
    search(i + 1, j, next)
    search(i, j - 1, next)
    search(i, j + 1, next)

    board[i][j] = c
}

        for (i in board.indices) {
            for (j in board[i].indices) {
                search(i, j, trie.root)
            }
        }
        
        return foundWords
    }

    class Trie {
        val root = TrieNode()

        fun insert(word: String) {
            var node = root
            for (c in word) {
                node = node.getOrPut(c)
            }
            node.word = word
        }
    }

    class TrieNode(val children: MutableMap<Char, TrieNode> = mutableMapOf(),
        var word: String? = null) {
            fun getOrPut(c: Char): TrieNode {
                if (children[c] == null) {
                    children[c] = TrieNode()
                }
                return children[c]!!
            }
        }
}
