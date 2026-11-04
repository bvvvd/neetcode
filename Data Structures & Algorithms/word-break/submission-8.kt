class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val root = TrieNode()
        for (word in wordDict) {
            var node = root
            for (c in word) {
                node = node.children.getOrPut(c) {TrieNode()}
            }
            node.isWord = true
        }

        val deadends = mutableSetOf<Int>()
        fun canForm(i: Int): Boolean {
            if (i >= s.length) return true
            if (deadends.contains(i)) return false

            var node = root
            for (j in i until s.length) {
                node = node.children[s[j]] ?: break
                if (node.isWord) {
                    if (canForm(j + 1)) {
                        return true
                    }
                }
            }

            deadends.add(i)
            return false
        }

        return canForm(0)
    }

    data class TrieNode(
        val children: MutableMap<Char, TrieNode> = mutableMapOf<Char, TrieNode>(),
        var isWord: Boolean = false) {
    }
}
