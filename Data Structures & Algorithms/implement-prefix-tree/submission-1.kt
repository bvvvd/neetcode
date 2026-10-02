class PrefixTree {

    private val root: TrieNode = TrieNode()

    fun insert(word: String) {
        var node = root
        for (c in word) {
            if (!node.has(c)) node.put(c)
            node = node.get(c)!!
        }
        node.isWord = true
    }

    fun search(word: String): Boolean = findByPrefix(word)?.isWord ?: false

    fun startsWith(prefix: String): Boolean = findByPrefix(prefix) != null

    fun findByPrefix(prefix: String): TrieNode? {
        var node = root
        for (c in prefix) {
            if (!node.has(c)) return null
            node = node.get(c)!!
        }
        return node
    }

    class TrieNode(private val children: MutableMap<Char, TrieNode> = mutableMapOf<Char, TrieNode>(),
        var isWord: Boolean = false) {

        fun has(c: Char): Boolean = children[c] != null

        fun put(c: Char) {
            children[c] = TrieNode()
        }

        fun get(c: Char) = children[c]
    }
}
