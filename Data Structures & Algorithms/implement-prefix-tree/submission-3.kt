class PrefixTree {
    private val root = TrieNode()

    fun insert(word: String) {
        var node = root
        word.forEach {
            node = node.children.getOrPut(it) { TrieNode() }
        }
        node.isWord = true
    }

    fun search(word: String): Boolean = find(word)?.isWord == true

    fun startsWith(prefix: String): Boolean = find(prefix) != null

    private fun find(prefix: String): TrieNode? {
        var node = root
        prefix.forEach {
            node = node.children[it] ?: return null
        }
        return node
    }

    private data class TrieNode(val children: MutableMap<Char, TrieNode> = mutableMapOf(), var isWord: Boolean = false)
}
