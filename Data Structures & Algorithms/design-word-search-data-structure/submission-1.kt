class WordDictionary {
    private val root = TrieNode()

    fun addWord(word: String) {
        var node = root
        for (c in word) {
            if (!node.has(c)) node.put(c)
            node = node.get(c)!!
        }
        node.isWord = true
    }

    fun search(word: String): Boolean {
        var node = root

        fun search(i: Int, node: TrieNode): Boolean {
            var currentNode = node
            var index = i
            while (index < word.length) {
                val c = word[index]
                index++
                if (c != '.') {
                    if (!currentNode.has(c)) return false
                    currentNode = currentNode.get(c)!!
                } else {
                    for (child in currentNode.children.values) {
                        if (search(index, child)) return true
                    }
                    return false
                }
            }
            return currentNode.isWord
        }

        return search(0, root)
    }

    private class TrieNode(val children: MutableMap<Char, TrieNode> = mutableMapOf(),
    var isWord: Boolean = false) {
        fun has(c: Char): Boolean = children.containsKey(c)
        fun put(c: Char) {
            children[c] = TrieNode()
        }
        fun get(c: Char) = children[c]
    }
}
